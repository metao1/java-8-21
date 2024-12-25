package com.metao.examples.encryptor;

import java.io.IOException;
import java.util.stream.Stream;

import static com.metao.examples.encryptor.FixedBatchSpliterator.withBatchSize;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CvsSpliteratorBenchmark {

    public static void main(String[] args) throws IOException {
        System.out.println("Start processing CSV Encryptor");
        long startTime = System.nanoTime();
        CVSFileReaderUtils.readStreamFileEncrypt("files/encrypted.txt");
        measureProcessing(startTime);
        System.out.println("Start processing fixed-batch stream");
        startTime = System.nanoTime();
        Stream<byte[]> stream = CVSFileReaderUtils.readStreamFileEncrypt("files/encrypted.txt");
        withBatchSize(stream, 1024);
        measureProcessing(startTime);
    }

    private static void measureProcessing(long startTime) {
        final long start = System.nanoTime();
            final double realTime = System.nanoTime() - start;
            final int cores = Runtime.getRuntime().availableProcessors();
            System.out.println("Cores          : " + cores);
            System.out.format("CPU time       : %.2f s\n", (double) startTime / SECONDS.toNanos(1));
            System.out.format("Real time      : %.2f s\n", realTime / SECONDS.toNanos(1));
            System.out.format("CPU utilization: %.2f%%\n\n", 100.0 * (double) startTime / realTime / cores);
    }

    private static Stream<byte[]> createStream(String input) {
        final byte[] encryptedText = CVSEncryptor.encrypt(input.getBytes());
        return Stream.of(encryptedText);
    }

}
