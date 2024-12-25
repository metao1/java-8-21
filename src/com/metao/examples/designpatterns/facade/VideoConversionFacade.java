package com.metao.examples.designpatterns.facade;

import com.metao.examples.designpatterns.facade.AudioMixer;
import com.metao.examples.designpatterns.facade.BitrateReader;
import com.metao.examples.designpatterns.facade.Codec;
import com.metao.examples.designpatterns.facade.CodecFactory;
import com.metao.examples.designpatterns.facade.MPEG4CompressionCodec;
import com.metao.examples.designpatterns.facade.OggCompressionCodec;
import com.metao.examples.designpatterns.facade.VideoFile;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        com.metao.examples.designpatterns.facade.VideoFile file = new com.metao.examples.designpatterns.facade.VideoFile(fileName);
        com.metao.examples.designpatterns.facade.Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }
        com.metao.examples.designpatterns.facade.VideoFile buffer = com.metao.examples.designpatterns.facade.BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
