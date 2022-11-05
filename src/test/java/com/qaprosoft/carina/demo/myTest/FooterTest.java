package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.enums.FooterMenuButton;
import com.qaprosoft.carina.demo.gui.enums.ForeignLink;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.utils.PageFactory;
import com.qaprosoft.carina.demo.utils.PageSwitcher;

public class FooterTest extends AbstractTest {

    @Test(description = "test footer")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();

        //Home page have 2 footer menu. In home page use home page methods to scroll and isPresented for footer menu
        //footer-menu buttons don`t work inside small footer menu on home page

        homePage.scrollToSmallFooterMenuOnHomePage();
        getDriver().findElement(By.xpath("//div[@id='footmenu']//a[contains(text(), 'News')]")).click();
        Assert.assertTrue(new NewsPage(getDriver()).isPageOpened(), "News page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.REVIEWS);
        Assert.assertTrue(new ReviewsPage(getDriver()).isPageOpened(), "Reviews page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.COMPARE);
        Assert.assertTrue(new CompareModelsPage(getDriver()).isPageOpened(), "Compare page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.COVERAGE);
        Assert.assertTrue(new CoveragePage(getDriver()).isPageOpened(), "Coverage page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.GLOSSARY);
        Assert.assertTrue(new GlossaryPage(getDriver()).isPageOpened(), "Glossary page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.FAQ);
        Assert.assertTrue(new FAQPage(getDriver()).isPageOpened(), "FAQ page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.RSS_FEED);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.gsmarena.com/rss-news-reviews.php3", "Rss page is not opened");
        getDriver().navigate().back();
        footerMenu.scrollToFooterMenuComponent();

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.YOUTUBE);
        PageSwitcher.switchForward(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.YOUTUBE.getValue(), "Youtube page not opened");
        PageSwitcher.switchBack(getDriver());

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.FACEBOOK);
        PageSwitcher.switchForward(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.FACEBOOK.getValue(), "FaceBook page not opened");
        PageSwitcher.switchBack(getDriver());

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.TWITTER);
        PageSwitcher.switchForward(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.TWITTER.getValue(), "Twitter page not opened");
        PageSwitcher.switchBack(getDriver());

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.INSTAGRAM);
        PageSwitcher.switchForward(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.INSTAGRAM.getValue(), "Instagram page not opened");
        PageSwitcher.switchBack(getDriver());

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.GSMARENA);
        Assert.assertTrue(new TeamPage(getDriver()).isPageOpened(), "Team page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.MOBILE_VERSION);
        //Check link depends previous page
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://m.gsmarena.com/team.php3", "Mobile site version page is not opened");
        homePage.scrollAndClickSwitchToDesktopVersionButton();

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.ANDROID_APP);
        PageSwitcher.switchForward(getDriver());
        Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.PLAY_GOOGLE_APP.getValue(), "Google play app page is not opened");
        PageSwitcher.switchBack(getDriver());

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.TOOLS);
        Assert.assertTrue(new ToolsPage(getDriver()).isPageOpened(), "Tools page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.CONTACT_US);
        Assert.assertTrue(new ContactPage(getDriver()).isPageOpened(), "Contact us page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.MERCH_STORE);
        PageSwitcher.switchForward(getDriver());
        Assert.assertTrue(new MerchPage(getDriver()).isPageOpened(), "Merch store page is not opened");
        PageSwitcher.switchBack(getDriver());

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.PRIVACY);
        Assert.assertTrue(new PrivacyPolicyPage(getDriver()).isPageOpened(), "Privacy page is not opened");

        footerMenu.scrollAndClickFooterMenuButton(FooterMenuButton.TERMS_OF_USE);
        Assert.assertTrue(new TermsPage(getDriver()).isPageOpened(), "Terms of use page is not opened");
    }

    @Test(description = "test footer on home page")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testFooterMenuOnHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();

        footerMenu.scrollToFooterMenuComponent();
        Assert.assertTrue(footerMenu.isFooterMenuComponentPresented(), "Footer menu not visible");
    }

    @Test(description = "test footer use page factory")
    @MethodOwner(owner = "Andrew Skrypka")
    public void testFooterMenuUsePageFactory() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();

        PageFactory pageFactory = new PageFactory();

        for (FooterMenuButton button : FooterMenuButton.values()) {
            footerMenu.scrollAndClickFooterMenuButton(button);
            if (button == FooterMenuButton.MERCH_STORE) {
                PageSwitcher.switchForward(getDriver());
                MerchPage merchPage = (MerchPage) pageFactory.footerMenuPage(FooterMenuButton.MERCH_STORE, getDriver());
                Assert.assertTrue(merchPage.isPageOpened(), "Merch page is not opened");
                PageSwitcher.switchBack(getDriver());
            } else if (button == FooterMenuButton.RSS_FEED) {
                Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.gsmarena.com/rss-news-reviews.php3",
                        "Rss page is not opened");
                getDriver().navigate().back();
                footerMenu.scrollToFooterMenuComponent();
            } else if (button == FooterMenuButton.YOUTUBE) {
                PageSwitcher.switchForward(getDriver());
                Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.YOUTUBE.getValue(), "Youtube page not opened");
                PageSwitcher.switchBack(getDriver());
            } else if (button == FooterMenuButton.FACEBOOK) {
                PageSwitcher.switchForward(getDriver());
                Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.FACEBOOK.getValue(), "Youtube page not opened");
                PageSwitcher.switchBack(getDriver());
            } else if (button == FooterMenuButton.TWITTER) {
                PageSwitcher.switchForward(getDriver());
                Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.TWITTER.getValue(), "Youtube page not opened");
                PageSwitcher.switchBack(getDriver());
            } else if (button == FooterMenuButton.INSTAGRAM) {
                PageSwitcher.switchForward(getDriver());
                Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.INSTAGRAM.getValue(), "Youtube page not opened");
                PageSwitcher.switchBack(getDriver());
            } else if (button == FooterMenuButton.MOBILE_VERSION) {
                //Check link depends previous page
                Assert.assertTrue(getDriver().getCurrentUrl().contains("https://m.gsmarena.com/"),
                        "Mobile site version page is not opened");
                homePage.scrollAndClickSwitchToDesktopVersionButton();
            } else if (button == FooterMenuButton.ANDROID_APP) {
                PageSwitcher.switchForward(getDriver());
                Assert.assertEquals(getDriver().getCurrentUrl(), ForeignLink.PLAY_GOOGLE_APP.getValue(),
                        "Google play app page is not opened");
                PageSwitcher.switchBack(getDriver());
            } else {
                Assert.assertTrue(pageFactory.footerMenuPage(button, getDriver()).isPageOpened(),
                        button.getValue() + " page is not opened");
            }
        }
    }
}
