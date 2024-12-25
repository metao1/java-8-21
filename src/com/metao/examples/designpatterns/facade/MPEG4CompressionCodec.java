package com.metao.examples.designpatterns.facade;

import com.metao.examples.designpatterns.dp.facade.Codec;

public class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";

    @Override
    public String getType() {
        return type;
    }
}
