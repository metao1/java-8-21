package com.metao.java8.encryptor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.metao.java8.encryptor.CVSFileReaderUtils.*;
import static com.metao.java8.encryptor.FixedBatchSpliterator.withBatchSize;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CvsSpliteratorBenchmark {

    private static double sink;

    public static void main(String[] args) throws IOException {
        final Path inputPath = createInput();
        System.out.println("Start processing CSV Encryptor");
        measureProcessing(Files.lines(inputPath));
        System.out.println("Start processing fixed-batch stream");
        measureProcessing(withBatchSize(Files.lines(inputPath), 1024));
        decryptInput();
    }

    private static void measureProcessing(Stream<String> stringStream) {
        final long start = System.nanoTime();
        try (Stream<String> line = stringStream) {
            long totalTime = line.parallel()
                    .mapToLong(CvsSpliteratorBenchmark::processLine)
                    .sum();
            final double cpuTime = totalTime, realTime = System.nanoTime() - start;
            final int cores = Runtime.getRuntime().availableProcessors();
            System.out.println("          Cores: " + cores);
            System.out.format("       CPU time: %.2f s\n", cpuTime / SECONDS.toNanos(1));
            System.out.format("      Real time: %.2f s\n", realTime / SECONDS.toNanos(1));
            System.out.format("CPU utilization: %.2f%%\n\n", 100.0 * cpuTime / realTime / cores);
        }
    }

    private static long processLine(String line) {
        final long localStart = System.nanoTime();
        double d = 0;
        for (int i = 0; i < line.length(); i++)
            for (int j = 0; j < line.length(); j++)
                d += Math.pow(line.charAt(i), line.charAt(j));
        sink += d;
        return System.nanoTime() - localStart;
    }

    private static Path createInput() throws IOException {
        final Path inputPath = Paths.get("encrypted.txt");
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(inputPath))) {
            for (int i = 0; i < 6_000; i++) {
                final byte[] encryptedText = CVSEncryptor.encrypt(System.nanoTime() + "");
                for (int j = 0; j < 25; j++) {
                    printWriter.print(encryptedText);
                }
                printWriter.println();
            }
        }
        return inputPath;
    }

    private static void decryptInput() throws FileNotFoundException {
         readFromFile("encrypted.txt");
    }
}
