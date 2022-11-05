package com.qaprosoft.carina.demo.gui.enums;

public enum FooterMenuButton {
    HOME("Home"),
    NEWS("News"),
    REVIEWS("Reviews"),
    COMPARE("Compare"),
    COVERAGE("Coverage"),
    GLOSSARY("Glossary"),
    FAQ("FAQ"),
    RSS_FEED("RSS feed"),
    YOUTUBE("Youtube"),
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    INSTAGRAM("Instagram"),
    GSMARENA("GSMArena.com"),
    MOBILE_VERSION("Mobile version"),
    ANDROID_APP("Android app"),
    TOOLS("Tools"),
    CONTACT_US("Contact us"),
    MERCH_STORE("Merch store"),
    PRIVACY("Privacy"),
    TERMS_OF_USE("Terms of use");

    private final String value;

    FooterMenuButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
