package com.qaprosoft.carina.demo.gui.enums;

public enum ForeignLink {
    YOUTUBE("https://www.youtube.com/channel/UCbLq9tsbo8peV22VxbDAfXA"),
    FACEBOOK("https://www.facebook.com/people/GSMArenacom/100066846038410/"),
    TWITTER("https://twitter.com/gsmarena_com"),
    INSTAGRAM("https://www.instagram.com/gsmarenateam/"),
    PLAY_GOOGLE_APP("https://play.google.com/store/apps/details?id=com.gsmarena.android");

    private final String value;

    ForeignLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
