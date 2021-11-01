package com.metao.java8.designpatterns.dp.facade;

public class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";

    @Override
    public String getType() {
        return type;
    }
}
