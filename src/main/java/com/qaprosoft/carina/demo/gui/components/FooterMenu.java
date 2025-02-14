/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.gui.enums.FooterMenuButton;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

public class FooterMenu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//div[@id='footer']")
    private ExtendedWebElement footerMenuComponent;

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(), '%s')]")
    private ExtendedWebElement footerMenuButton;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public FooterMenu(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(driver);
    }

    public void scrollToFooterMenuComponent() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (driver.getCurrentUrl().equals("https://www.gsmarena.com/")) {
            while (!footerMenuComponent.isElementPresent()) {
//            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                footerMenuComponent.scrollTo();
                pause(1);
            }
        } else {
            footerMenuComponent.scrollTo();
            pause(1);
        }
    }

    public void clickFooterMenuButton(FooterMenuButton footerMenuButton) {
        this.footerMenuButton.format(footerMenuButton.getValue()).click();
    }

    public boolean isFooterMenuComponentPresented() {
        return footerMenuComponent.isElementPresent();
    }

    public void scrollAndClickFooterMenuButton(FooterMenuButton footerMenuButton) {
        scrollToFooterMenuComponent();
        this.footerMenuButton.format(footerMenuButton.getValue()).click();
    }
}
