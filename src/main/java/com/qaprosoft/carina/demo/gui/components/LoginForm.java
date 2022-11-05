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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginFormComponent;

    @FindBy(xpath = "//*[@id='login-popup2']/form/p")
    private ExtendedWebElement loginFormText;

    @FindBy(xpath = "(//input[@id='email'])[1]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "(//input[@id='upass'])[1]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@class='button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class='forgot']")
    private ExtendedWebElement forgotPasswordButton;

    @FindBy(xpath = "//div[@class='normal-text res-error']/p")
    private ExtendedWebElement loginFailErrorText;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFormComponentPresented() {
        return loginFormComponent.getElement().getCssValue("display").equals("block");
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginFormTextString() {
        return loginFormText.getText();
    }

    public boolean isEmailFieldPresent() {
        return emailField.isElementPresent();
    }

    public boolean isPasswordFieldPresented() {
        return passwordField.isElementPresent();
    }

    public boolean isLoginButtonPresented() {
        return loginButton.isElementPresent();
    }

    public boolean isLoginButtonClickable() {
        return loginButton.isClickable();
    }

    public void hoverOverLoginButton() {
        loginButton.hover();
        pause(2);
    }

    public String getLoginButtonColorAsString() {
        return loginButton.getElement().getCssValue("background-color");
    }

    public boolean isForgotPasswordButtonPresented() {
        return forgotPasswordButton.isElementPresent();
    }

    public boolean isForgotPasswordButtonClickable() {
        return forgotPasswordButton.isClickable();
    }

    public void typeEmailAndPasswordAndClickLoginButton(String email, String password) {
        typeEmail(email);
        typePassword(password);
        loginButton.click();
    }

    public String getEmailFieldValidationMessage() {
        return emailField.getAttribute("validationMessage");
    }

    public String getPasswordFieldValidationMessage() {
        return passwordField.getAttribute("validationMessage");
    }

    public String getLoginFailText() {
        return loginFailErrorText.getText();
    }
}
