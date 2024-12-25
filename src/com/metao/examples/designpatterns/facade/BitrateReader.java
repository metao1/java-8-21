package com.metao.examples.designpatterns.facade;

import com.metao.examples.designpatterns.facade.Codec;
import com.metao.examples.designpatterns.facade.VideoFile;

public class BitrateReader {
    public static com.metao.examples.designpatterns.facade.VideoFile read(com.metao.examples.designpatterns.facade.VideoFile file, com.metao.examples.designpatterns.facade.Codec codec) {
        System.out.println("BitrateReader: codec type:" + codec.getType() + ", reading file...");
        return file;
    }

    public static com.metao.examples.designpatterns.facade.VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: codec type:" + codec.getType() + ", writing file...");
        return buffer;
    }
}
