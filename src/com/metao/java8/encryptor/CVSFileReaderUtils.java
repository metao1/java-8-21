package com.metao.java8.encryptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CVSFileReaderUtils {

    public static void generateDecryptedFile(String fileName) throws FileNotFoundException {
        try (Stream<byte[]> fileInputStream = CVSStreamUtils.cvsStream(new FileInputStream(fileName))) {
            List<byte[]> collect = fileInputStream.parallel()
                    .map(CVSEncryptor::decrypt)
                    .collect(Collectors.toList());
            System.out.println(collect);
        }
    }

}
