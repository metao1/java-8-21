package com.metao.examples.designpatterns.proxy;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, com.metao.examples.designpatterns.proxy.Video> cachePopular = new HashMap<String, com.metao.examples.designpatterns.proxy.Video>();
    private HashMap<String, com.metao.examples.designpatterns.proxy.Video> cacheAll = new HashMap<String, com.metao.examples.designpatterns.proxy.Video>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, com.metao.examples.designpatterns.proxy.Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public com.metao.examples.designpatterns.proxy.Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}