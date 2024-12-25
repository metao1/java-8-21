package com.metao.examples.designpatterns.facade;

public class OggCompressionCodec implements Codec {
    public String type = "ogg";

    @Override
    public String getType() {
        return type;
    }
}
