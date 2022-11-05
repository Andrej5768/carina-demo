package com.qaprosoft.carina.demo.utils;

import org.openqa.selenium.WebDriver;

public class PageSwitcher {

    private static String originalWindow;

    public static void switchForward(WebDriver webDriver) {
        originalWindow = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
            }
        }
    }

    public static void switchBack(WebDriver webDriver) {
        webDriver.close();
        webDriver.switchTo().window(originalWindow);
        originalWindow = "";
    }
}
