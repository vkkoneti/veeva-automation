package com.veeva.automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By pageHeader = By.tagName("h1");

    public void openHomePage(String url) {
        openUrl(url);
    }


}
