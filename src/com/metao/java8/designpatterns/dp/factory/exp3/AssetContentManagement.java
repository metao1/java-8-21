package com.metao.java8.designpatterns.dp.factory.exp3;

import java.util.List;
import java.util.stream.Collectors;

class AssetContentManagement implements ContentManagement {

    @Override
    public String getContent(List<String> onlineIds) {
        return onlineIds
                .stream()
                .collect(Collectors.joining(",", "[", "]"));
    }
}
