package com.metao.java8.encryptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

public class CVSFileReaderUtils {

    public static Stream<byte[]> readStreamFileDecrypted(final String fileName) throws FileNotFoundException {
        try (Stream<byte[]> fileInputStream = CVSStreamUtils.cvsStream(new FileInputStream(fileName))) {
            return fileInputStream.parallel()
                    .map(CVSEncryptor::decrypt);
        }
    }

    public static Stream<byte[]> readStreamFileEncrypt(final String fileName) throws FileNotFoundException {
        try (Stream<byte[]> fileInputStream = CVSStreamUtils.cvsStream(new FileInputStream(fileName))) {
            return fileInputStream.parallel()
                    .map(CVSEncryptor::encrypt);
        }
    }

}
