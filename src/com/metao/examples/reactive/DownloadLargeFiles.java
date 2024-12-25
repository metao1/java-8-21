package com.metao.examples.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class DownloadLargeFiles {

    public static void main(String[] args) throws IOException {
        Path ipPath1 = Paths.get("files/hugefile1.txt");
        var list = List.of(ipPath1);
        Flux<Path> pathFlux = Flux.fromStream(list::stream)
                .repeat(5);
        Path opPath = Paths.get("files/out.txt");
        BufferedWriter bw = Files.newBufferedWriter(opPath, StandardOpenOption.CREATE, StandardOpenOption.CREATE);
        Flux<String> stringFlux = pathFlux
                .flatMap(path -> Mono.fromCallable(() -> readFromFile(path))
                        .flatMapMany(s -> Flux.using(() -> s
                                        , Flux::fromStream
                                        , Stream::close
                                ).subscribeOn(Schedulers.newParallel("file-copy", 10))
                                .share()));
        Flux<Stream<String>> streamFlux = pathFlux
                .flatMap(path -> Mono.fromCallable(() -> readFromFile(path)));

        streamFlux
                .subscribe(s -> write(bw, s),
                        (e) -> close(bw),  // close file if error / oncomplete
                        () -> close(bw)
                );

    }

    private static Stream<String> readFromFile(Path ipPath) throws IOException {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        return Files.lines(ipPath);
    }


    private static void close(Closeable closeable) {
        try {
            closeable.close();
            System.out.println("Closed the resource");
            System.exit(0);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void write(BufferedWriter bw, String string) {
        try {
            System.out.println(string);
            bw.write(string);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void write(BufferedWriter bw, Stream<String> string) {
        try {
            string.forEach(item -> {
                try {
                    System.out.println(item);
                    bw.write(item);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            });
            bw.newLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
