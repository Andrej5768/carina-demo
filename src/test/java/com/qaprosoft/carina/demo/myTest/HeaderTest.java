package com.qaprosoft.carina.demo.myTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.enums.MainMenuButton;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.utils.PageFactory;
import com.qaprosoft.carina.demo.utils.PageSwitcher;

public class HeaderTest extends AbstractTest {

    @Test(description = "test main menu button link")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testHeaderMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.openMenuList();
        Assert.assertTrue(headerMenu.isMainMenuPopUpPresented(), "Pop up main menu not present");

        headerMenu.clickMainMenuButton(MainMenuButton.NEWS);
        Assert.assertTrue(new NewsPage(getDriver()).isPageOpened(), "News page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.REVIEWS);
        Assert.assertTrue(new ReviewsPage(getDriver()).isPageOpened(), "Reviews page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.VIDEOS);
        Assert.assertTrue(new VideosPage(getDriver()).isPageOpened(), "Videos page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.FEATURED);
        Assert.assertTrue(new FeaturedPage(getDriver()).isPageOpened(), "Featured page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.PHONE_FINDER);
        Assert.assertTrue(new PhoneFinderPage(getDriver()).isPageOpened(), "Phone finder page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.DEALS);
        Assert.assertTrue(new DealsPage(getDriver()).isPageOpened(), "Deals page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.MERCH);
        PageSwitcher.switchForward(getDriver());
        Assert.assertTrue(new MerchPage(getDriver()).isPageOpened(), "Merch page is not opened");
        PageSwitcher.switchBack(getDriver());

        headerMenu.clickMainMenuButton(MainMenuButton.COVERAGE);
        Assert.assertTrue(new CoveragePage(getDriver()).isPageOpened(), "Coverage page is not opened");

        headerMenu.clickMainMenuButton(MainMenuButton.CONTACT);
        Assert.assertTrue(new ContactPage(getDriver()).isPageOpened(), "Contact page is not opened");
    }

    @Test(description = "test main menu button link use page factory")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testHeaderMenuUsePageFactory() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.openMenuList();
        Assert.assertTrue(headerMenu.isMainMenuPopUpPresented(), "Pop up main menu not present");

        PageFactory pageFactory = new PageFactory();

        for (MainMenuButton button : MainMenuButton.values()) {
            headerMenu.clickMainMenuButton(button);
            if (button == MainMenuButton.MERCH) {
                PageSwitcher.switchForward(getDriver());
                MerchPage merchPage = (MerchPage) pageFactory.headerMenuPage(MainMenuButton.MERCH, getDriver());
                Assert.assertTrue(merchPage.isPageOpened(), "Merch page is not opened");
                PageSwitcher.switchBack(getDriver());
            } else {
                Assert.assertTrue(pageFactory.headerMenuPage(button, getDriver()).isPageOpened(), button.getValue() + " page is not opened");
            }
        }
    }
}
