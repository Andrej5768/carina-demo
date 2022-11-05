package com.qaprosoft.carina.demo.myTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class LoginTest extends AbstractTest {

    @DataProvider(name = "login-form-with-redirect")
    public static Object[][] withRedirectToLoginPage() {
        return new Object[][]{
                {StringGenerator.generateEmail(), StringGenerator.generateWord(10), "Reason: User record not found."},
                {EMAIL, StringGenerator.generateWord(10), "Reason: Wrong password."},
                {StringGenerator.generateEmail(), PASSWORD, "Reason: User record not found."}
        };
    }

    private final static String EMAIL = "";

    private final static String PASSWORD = "";

    private final static String RED_COLOR = "rgba(213, 0, 0, 1)";

    @Test(description = "test login to account")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testLoginToAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginForm loginForm = headerMenu.openLoginPopUp();
        Assert.assertTrue(loginForm.isLoginFormComponentPresented(), "Login pop up don`t present");

        loginForm.typeEmail(EMAIL);
        loginForm.typePassword(PASSWORD);
        loginForm.clickLoginButton();
        Assert.assertTrue(homePage.isPageOpened(), "Login not success");
    }

    @Test(description = "test login form pop up and element")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testLoginFormAllElementPresentAndClickable() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SoftAssert softAssert = new SoftAssert();

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginForm loginForm = headerMenu.openLoginPopUp();
        softAssert.assertTrue(loginForm.isLoginFormComponentPresented(), "Login form pop up don`t present");
        softAssert.assertEquals(loginForm.getLoginFormTextString(), "Login", "Login dont have 'Login' text");
        softAssert.assertTrue(loginForm.isEmailFieldPresent(), "Email text field not presented");
        softAssert.assertTrue(loginForm.isPasswordFieldPresented(), "Password field not presented");

        loginForm.typeEmail("some@text.com");
        loginForm.typePassword("password123");
        loginForm.typeEmail("");
        loginForm.typePassword("");

        softAssert.assertTrue(loginForm.isLoginButtonPresented(), "Login button not presented");
        softAssert.assertTrue(loginForm.isLoginButtonClickable(), "Login button not clickable");
        loginForm.hoverOverLoginButton();
        softAssert.assertEquals(loginForm.getLoginButtonColorAsString(), RED_COLOR, "Login button not red when covered");

        softAssert.assertTrue(loginForm.isForgotPasswordButtonPresented(), "Forgot password button not presented");
        softAssert.assertTrue(loginForm.isForgotPasswordButtonClickable(), "Forgot password button not clickable");

        softAssert.assertAll();
    }

    @Test(description = "test login form validation message")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testLoginFormValidationMessage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SoftAssert softAssert = new SoftAssert();

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginForm loginForm = headerMenu.openLoginPopUp();
        Assert.assertTrue(loginForm.isLoginFormComponentPresented(), "Login pop up don`t present");

//        empty email, empty pass
        loginForm.typeEmailAndPasswordAndClickLoginButton("", "");
        softAssert.assertEquals(loginForm.getEmailFieldValidationMessage(), "Заполните это поле.", "Step 1: Validation message not equals");
        softAssert.assertEquals(loginForm.getPasswordFieldValidationMessage(), "Заполните это поле.", "Step 1: Validation message not equals");

//        incorrect email, empty pass
        loginForm.typeEmailAndPasswordAndClickLoginButton(StringGenerator.generateEmail(), "");
        softAssert.assertEquals(loginForm.getEmailFieldValidationMessage(), "", "Step 2: Validation message not equals");
        softAssert.assertEquals(loginForm.getPasswordFieldValidationMessage(), "Заполните это поле.", "Step 2: Validation message not equals");

//        empty email, incorrect pass
        loginForm.typeEmailAndPasswordAndClickLoginButton("", StringGenerator.generateWord(10));
        softAssert.assertEquals(loginForm.getEmailFieldValidationMessage(), "Заполните это поле.", "Step 3: Validation message not equals");
        softAssert.assertEquals(loginForm.getPasswordFieldValidationMessage(), "", "Step 3: Validation message not equals");

//        incorrect email, incorrect pass
        loginForm.typeEmailAndPasswordAndClickLoginButton(StringGenerator.generateEmail(), StringGenerator.generateWord(10));
        softAssert.assertEquals(loginForm.getLoginFailText(), "Reason: User record not found.", "Step 4: Login failed message not equals");

//        email without "@", correct pass
        loginForm.typeEmailAndPasswordAndClickLoginButton(StringGenerator.generateWord(10), PASSWORD);
        softAssert.assertTrue(loginForm.getEmailFieldValidationMessage().contains("Адрес электронной почты должен содержать символ \"@\"."), "Step 5: Validation message not equals");
        softAssert.assertEquals(loginForm.getPasswordFieldValidationMessage(), "", "Step 5: Validation message not equals");

//        email without tex after "@", correct pass
        loginForm.typeEmailAndPasswordAndClickLoginButton(StringGenerator.generateWord(10) + "@", PASSWORD);
        softAssert.assertTrue(loginForm.getEmailFieldValidationMessage().contains("Введите часть адреса после символа \"@\"."), "Step 6: Validation message not equals");
        softAssert.assertEquals(loginForm.getPasswordFieldValidationMessage(), "", "Step 6: Validation message not equals");

//        correct email, incorrect pass
        loginForm.typeEmailAndPasswordAndClickLoginButton(EMAIL, StringGenerator.generateWord(10));
        softAssert.assertEquals(loginForm.getLoginFailText(), "Reason: Wrong password.", "Step 7: Login failed message not equals");

//        incorrect email, correct pass
        loginForm.typeEmailAndPasswordAndClickLoginButton(StringGenerator.generateEmail(), PASSWORD);
        softAssert.assertEquals(loginForm.getLoginFailText(), "Reason: User record not found.", "Step 8: Login failed message not equals");

        softAssert.assertAll();
    }

    @Test(description = "test login form validation message with data provider", dataProvider = "login-form", dataProviderClass = MyDataProvider.class)
    @MethodOwner(owner = "Andrew Skrypka")
    public void testLoginFormValidationMessageWithDataProvider(String email, String password, String emailMessage, String passwordMessage) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SoftAssert softAssert = new SoftAssert();

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginForm loginForm = headerMenu.openLoginPopUp();
        Assert.assertTrue(loginForm.isLoginFormComponentPresented(), "Login pop up don`t present");

        loginForm.typeEmailAndPasswordAndClickLoginButton(email, password);

        softAssert.assertTrue(loginForm.getEmailFieldValidationMessage().contains(emailMessage), "Validation message not equals");
        softAssert.assertTrue(loginForm.getPasswordFieldValidationMessage().contains(passwordMessage), "Validation message not equals");

        softAssert.assertAll();
    }

    @Test(description = "test login form validation message with data provider. With redirect to login page", dataProvider = "login-form-with-redirect")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testLoginWithRedirectToLoginPageWithDataProvider(String email, String password, String failMessage) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginForm loginForm = headerMenu.openLoginPopUp();
        Assert.assertTrue(loginForm.isLoginFormComponentPresented(), "Login pop up don`t present");

        loginForm.typeEmailAndPasswordAndClickLoginButton(email, password);

        Assert.assertEquals(loginForm.getLoginFailText(), failMessage, "Login failed message not equals");
    }
}
