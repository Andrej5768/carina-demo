package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class BlogPage extends AbstractPage {

    public BlogPage(WebDriver driver) {
        super(driver);
        setPageURL("/blog.php3");
    }
}
