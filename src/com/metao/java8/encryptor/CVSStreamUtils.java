package com.metao.java8.encryptor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CVSStreamUtils {
    public static Stream<String[]> cvsStream(InputStream in) {
        final CVSReader cr = new CVSReader(new InputStreamReader(in));
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
