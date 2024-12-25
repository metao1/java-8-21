package com.metao.examples.designpatterns.decorator;

import com.metao.examples.designpatterns.decorator.DataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonDataSource implements DataSource<String> {

    private final Path filePath;

    public JsonDataSource(String strPath) {
        try {
            Path path = Path.of(strPath);
            if (!Files.exists(path)) {
                this.filePath = Files.createFile(new File(strPath).toPath());
            } else {
                this.filePath = path;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(String data) {
        if (data != null && !data.isBlank()) {
            try {
                Files.writeString(filePath, data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String readData() {
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
