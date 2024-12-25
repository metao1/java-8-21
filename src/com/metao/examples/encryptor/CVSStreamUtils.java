package com.metao.examples.encryptor;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CVSStreamUtils {

    public static Stream<byte[]> cvsStream(InputStream in) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        final CVSReader cr = new CVSReader(bufferedInputStream);
        return StreamSupport.stream(new CvsSpliterator(cr), true)
                .onClose(() -> {
                    try {
                        cr.close();
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
    }
}
