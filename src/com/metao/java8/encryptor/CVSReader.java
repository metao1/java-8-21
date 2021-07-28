package com.metao.java8.encryptor;

import java.io.IOException;
import java.io.InputStreamReader;

public class CVSReader {

    private final InputStreamReader inputStream;

    public CVSReader(InputStreamReader inputStreamReader) {
        this.inputStream = inputStreamReader;
    }

    public byte[] readNext() {
        return new byte[0];
    }

    public void close() throws IOException {

    }
}
