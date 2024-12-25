package com.metao.examples.designpatterns.facade;

import com.metao.examples.designpatterns.facade.Codec;

public class OggCompressionCodec implements Codec {
    public String type = "ogg";

    @Override
    public String getType() {
        return type;
    }
}
