package com.metao.java8.encryptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

import static com.metao.java8.encryptor.CVSEncryptor.decrypt;

public class CVSFileReaderUtils {

    public static void generateDecryptedFile(String fileName) throws FileNotFoundException {
        try (Stream<String[]> fileInputStream = CVSStreamUtils.cvsStream(new FileInputStream(fileName))) {
            fileInputStream.parallel()
                    .map(fields -> decrypt(String.join("", fields)))
                    .forEachOrdered(CVSFileReaderUtils::writeIntoFile);
        }
    }

    private static void writeIntoFile(byte[] bytes) {

    }

}
