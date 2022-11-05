package com.qaprosoft.carina.demo.gui.enums;

public enum MainMenuButton {
    HOME("Home"),
    NEWS("News"),
    REVIEWS("Reviews"),
    VIDEOS("Videos"),
    FEATURED("Featured"),
    PHONE_FINDER("Phone Finder"),
    DEALS("Deals"),
    MERCH("Merch"),
    COVERAGE("Coverage"),
    CONTACT("Contact");

    private final String value;

    MainMenuButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
