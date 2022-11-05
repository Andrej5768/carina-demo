package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;

public class RegistrationTest implements IAbstractTest {

    @Test(description = "test registration with generated date")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testNewUserRegistration() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        SignUpPage signUpPage = headerMenu.openSignUpPage();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign up page not opened");

        signUpPage.typeNickname(StringGenerator.generateWord(10));
        signUpPage.typeEmail(StringGenerator.generateEmail());
        signUpPage.typePassword(StringGenerator.generateWord(12));
        signUpPage.firstCheckboxOn();
        signUpPage.secondCheckboxOn();
        signUpPage.clickSubmitButton();
        Assert.assertEquals(signUpPage.getSuccessRegistrationText(), "Your account was created.", "Registration not success");
    }
}
