package com.metao.examples.designpatterns.factory.exp3;

import java.util.List;
import java.util.stream.Collectors;

class AssetContentManagement implements com.metao.examples.designpatterns.factory.exp3.ContentManagement {

    @Override
    public String getContent(List<String> onlineIds) {
        return onlineIds
                .stream()
                .collect(Collectors.joining(",", "[", "]"));
    }
}
