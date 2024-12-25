package com.metao.examples.designpatterns.facade;

import com.metao.examples.designpatterns.dp.facade.AudioMixer;
import com.metao.examples.designpatterns.dp.facade.BitrateReader;
import com.metao.examples.designpatterns.dp.facade.Codec;
import com.metao.examples.designpatterns.dp.facade.CodecFactory;
import com.metao.examples.designpatterns.dp.facade.MPEG4CompressionCodec;
import com.metao.examples.designpatterns.dp.facade.OggCompressionCodec;
import com.metao.examples.designpatterns.dp.facade.VideoFile;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        com.metao.examples.designpatterns.dp.facade.VideoFile file = new com.metao.examples.designpatterns.dp.facade.VideoFile(fileName);
        com.metao.examples.designpatterns.dp.facade.Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }
        com.metao.examples.designpatterns.dp.facade.VideoFile buffer = com.metao.examples.designpatterns.dp.facade.BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
