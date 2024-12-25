package com.metao.examples.designpatterns.decorator;

import com.metao.examples.designpatterns.decorator.DataSource;

import java.io.*;

public class FileDataSource implements DataSource<String> {
    private final String path;

    public FileDataSource(String path) {
        this.path = path;
    }

    @Override
    public void writeData(String data) {
        File file = new File(path);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(path);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
