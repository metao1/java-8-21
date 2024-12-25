package com.metao.examples.encryptor;

import java.io.IOException;
import java.util.stream.Stream;

public class CvsSpliteratorBenchmark {

    public static void main(String[] args) throws IOException {
        System.out.println("Start processing CSV Encryptor");
        long startTime = System.nanoTime();
        CVSFileReaderUtils.readStreamFileEncrypt("files/encrypted.txt");
        measureProcessing(startTime);
        System.out.println("Start processing fixed-batch stream");
        startTime = System.nanoTime();
        Stream<byte[]> stream = CVSFileReaderUtils.readStreamFileEncrypt("files/encrypted.txt");
        //withBatchSize(stream, 1024);
        measureProcessing(startTime);
    }

    private static void measureProcessing(long startTime) {
        final long endTime = System.nanoTime();
        final double consumedTime = System.nanoTime() - endTime;
        final int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores          : " + cores);
        System.out.format("CPU time       : %.2f ns\n", consumedTime);
    }

}
