package com.metao.java8.encryptor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static com.metao.java8.encryptor.CVSFileReaderUtils.generateDecryptedFile;
import static com.metao.java8.encryptor.FixedBatchSpliterator.withBatchSize;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CvsSpliteratorBenchmark {

    private static double sink;

    public static void main(String[] args) throws IOException {
        System.out.println("Start processing CSV Encryptor");
        measureProcessing(createStream("stream-in-0"));
        System.out.println("Start processing fixed-batch stream");
        measureProcessing(withBatchSize(createStream("stream-in-1"), 1024));
    }

    private static void measureProcessing(Stream<byte[]> stringStream) {
        final long start = System.nanoTime();
        try (Stream<byte[]> line = stringStream) {
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

    private static long processLine(byte[] line) {
        final long localStart = System.nanoTime();
        double d = 0;
        for (int i = 0; i < line.length; i++)
            for (byte b : line) d += Math.pow(b, b);
        sink += d;
        return System.nanoTime() - localStart;
    }

    private static Stream<byte[]> createStream(String input) {
        List<byte[]> streamBuffer = new LinkedList<>();
        int BUFFER_SIZE = 1880008;
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        for (int i = 0; i < BUFFER_SIZE; i++) {
            buffer.putLong(System.nanoTime());
            final byte[] encryptedText = CVSEncryptor.encrypt(buffer.array());
            buffer.clear();
            streamBuffer.add(encryptedText);
        }
        return streamBuffer.stream();
    }

}
