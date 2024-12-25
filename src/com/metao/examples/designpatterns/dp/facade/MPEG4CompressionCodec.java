package com.metao.examples.designpatterns.dp.facade;

public class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";

    @Override
    public String getType() {
        return type;
    }
}
