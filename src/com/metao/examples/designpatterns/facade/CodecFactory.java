package com.metao.examples.designpatterns.facade;

import com.metao.examples.designpatterns.facade.Codec;
import com.metao.examples.designpatterns.facade.MPEG4CompressionCodec;
import com.metao.examples.designpatterns.facade.OggCompressionCodec;
import com.metao.examples.designpatterns.facade.VideoFile;

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
