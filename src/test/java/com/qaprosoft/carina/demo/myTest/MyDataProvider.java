package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import org.testng.annotations.DataProvider;

public class MyDataProvider {

    @DataProvider(name = "login-form")
    public static Object[][] withoutRedirectToLoginPage() {
        return new Object[][]{
                //email, password, emailValidationMessage, passwordValidationMessage
                {"", "", "Заполните это поле.", "Заполните это поле."},
                {StringGenerator.generateEmail(), "", "", "Заполните это поле."},
                {"", StringGenerator.generateWord(10), "Заполните это поле.", ""},
                {StringGenerator.generateWord(10), "fadavag229", "Адрес электронной почты должен содержать символ \"@\".", ""},
                {StringGenerator.generateWord(10) + "@", "fadavag229", "Введите часть адреса после символа \"@\".", ""}
        };
    }
}
