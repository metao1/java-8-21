package com.metao.examples.designpatterns.proxy;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, com.metao.examples.designpatterns.proxy.Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public com.metao.examples.designpatterns.proxy.Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    private HashMap<String, com.metao.examples.designpatterns.proxy.Video> getRandomVideos() {
        System.out.print("Downloading populars... ");

        experienceNetworkLatency();
        HashMap<String, com.metao.examples.designpatterns.proxy.Video> hmap = new HashMap<String, com.metao.examples.designpatterns.proxy.Video>();
        hmap.put("catzzzzzzzzz", new com.metao.examples.designpatterns.proxy.Video("sadgahasgdas", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new com.metao.examples.designpatterns.proxy.Video("mkafksangasj", "Dogplay with ball.mp4"));
        hmap.put("dancesvideoo", new com.metao.examples.designpatterns.proxy.Video("asdfas3ffasd", "Dancing video.mpq"));
        hmap.put("dlsdk5jfslaf", new com.metao.examples.designpatterns.proxy.Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new com.metao.examples.designpatterns.proxy.Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        System.out.print("Done!" + "\n");
        return hmap;
    }

    private com.metao.examples.designpatterns.proxy.Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        com.metao.examples.designpatterns.proxy.Video video = new Video(videoId, "Some video title");

        System.out.print("Done!" + "\n");
        return video;
    }

}