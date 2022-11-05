package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.demo.gui.enums.FooterMenuButton;
import com.qaprosoft.carina.demo.gui.enums.MainMenuButton;
import com.qaprosoft.carina.demo.gui.pages.*;

public class PageFactory {

    public AbstractPage headerMenuPage(MainMenuButton button, WebDriver driver) {
        AbstractPage page = null;
        switch (button) {
            case HOME:
                page = new HomePage(driver);
                break;
            case NEWS:
                page = new NewsPage(driver);
                break;
            case DEALS:
                page = new DealsPage(driver);
                break;
            case MERCH:
                page = new MerchPage(driver);
                break;
            case VIDEOS:
                page = new VideosPage(driver);
                break;
            case CONTACT:
                page = new ContactPage(driver);
                break;
            case REVIEWS:
                page = new ReviewsPage(driver);
                break;
            case COVERAGE:
                page = new CoveragePage(driver);
                break;
            case FEATURED:
                page = new FeaturedPage(driver);
                break;
            case PHONE_FINDER:
                page = new PhoneFinderPage(driver);
                break;
        }
        return page;
    }

    public AbstractPage footerMenuPage(FooterMenuButton button, WebDriver driver) {
        AbstractPage page = null;
        switch (button) {
            case HOME:
                page = new HomePage(driver);
                break;
            case NEWS:
                page = new NewsPage(driver);
                break;
            case REVIEWS:
                page = new ReviewsPage(driver);
                break;
            case COMPARE:
                page = new CompareModelsPage(driver);
                break;
            case GLOSSARY:
                page = new GlossaryPage(driver);
                break;
            case FAQ:
                page = new FAQPage(driver);
                break;
            case RSS_FEED:
                page = new RSSPage(driver);
                break;
            case GSMARENA:
                page = new TeamPage(driver);
                break;
            case TOOLS:
                page = new ToolsPage(driver);
                break;
            case CONTACT_US:
                page = new ContactPage(driver);
                break;
            case MERCH_STORE:
                page = new MerchPage(driver);
                break;
            case PRIVACY:
                page = new PrivacyPolicyPage(driver);
                break;
            case TERMS_OF_USE:
                page = new TermsPage(driver);
                break;
            case COVERAGE:
                page = new CoveragePage(driver);
                break;
        }
        return page;
    }
}
