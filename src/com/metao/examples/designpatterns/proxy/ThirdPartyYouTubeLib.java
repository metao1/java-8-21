package com.metao.examples.designpatterns.proxy;

import com.metao.examples.designpatterns.dp.proxy.Video;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, com.metao.examples.designpatterns.dp.proxy.Video> popularVideos();

    Video getVideo(String videoId);
}