package com.metao.java8.encryptor;

import java.io.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CVSStreamUtils {
    public static Stream<byte[]> cvsStream(InputStream in) {
        final CVSReader cr = new CVSReader(new BufferedInputStream(in));
        return StreamSupport.stream(new CvsSpliterator(cr), false)
                .onClose(() -> {
                    try {
                        cr.close();
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
    }
}
