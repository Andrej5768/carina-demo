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
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.gui.enums.MainMenuButton;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//*[@id='header']/div/div/button")
    private ExtendedWebElement showMainMenuComponentButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), '%s')]")
    private ExtendedWebElement mainMenuButton;

    @FindBy(xpath = "//*[@id='menu']")
    private ExtendedWebElement mainMenuComponent;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//i[@class='head-icon icon-login']")
    private ExtendedWebElement showLoginFormComponentButton;

    @FindBy(xpath = "//a[@href='register.php3']")
    private ExtendedWebElement signUpButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public LoginForm openLoginPopUp() {
        showLoginFormComponentButton.click();
        return new LoginForm(driver);
    }

    public SignUpPage openSignUpPage() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public void openMenuList() {
        showMainMenuComponentButton.click();
    }

    public void clickMainMenuButton(MainMenuButton mainMenuButton) {
        this.mainMenuButton.format(mainMenuButton.getValue()).click();
    }

    public CompareModelsPage openComparePage() {
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(driver);
    }

    public boolean isMainMenuPopUpPresented() {
        return mainMenuComponent.isElementPresent();
    }
}
