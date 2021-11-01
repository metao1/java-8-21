package com.metao.java8.designpatterns.dp.facade;

public class OggCompressionCodec implements Codec {
    public String type = "ogg";

    @Override
    public String getType() {
        return type;
    }
}
