package com.metao.examples.encryptor;

import java.io.BufferedInputStream;
import java.io.IOException;

public class CVSReader {

    private final BufferedInputStream inputStream;

    public CVSReader(BufferedInputStream inputStreamReader) {
        this.inputStream = inputStreamReader;
    }

    public byte[] readNext() {
        int availableBytes;
        final int BUFFER_SIZE = 1024;
        byte[] buffer = new byte[BUFFER_SIZE];
        try {

            while ((availableBytes = inputStream.available()) > 0) {
                availableBytes = inputStream.read(buffer, 0, Math.min(availableBytes, BUFFER_SIZE));
            }
            return buffer;
        } catch (IOException e) {
            try {
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public void close() throws IOException {
        inputStream.close();
    }
}
