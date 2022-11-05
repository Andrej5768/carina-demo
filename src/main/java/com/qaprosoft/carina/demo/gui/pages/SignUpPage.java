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
package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;

public class SignUpPage extends AbstractPage {

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//input[@id='uname']")
    private ExtendedWebElement nicknameField;

    @FindBy(xpath = "(//input[@id='email'])[2]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "(//input[@id='upass'])[2]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement iAgreeCheckbox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement iHave16OldCheckbox;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    @FindBy(xpath = "(//input[@id='nick-submit'])[2]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='normal-text res-success']//h3")
    private ExtendedWebElement successRegistrationText;

    public void typeNickname(String nickname) {
        nicknameField.type(nickname);
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public void firstCheckboxOn() {
        iAgreeCheckbox.click();
    }

    public void secondCheckboxOn() {
        iHave16OldCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getSuccessRegistrationText() {
        return successRegistrationText.getText();
    }
}
