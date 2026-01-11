package com.veeva.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dp2HomePage extends BasePage {

    // ===== Footer =====
    private final By footer =
            By.tagName("footer");

    private final By footerLinks =
            By.cssSelector("footer a");

    public void openDp2HomePage() {
        openUrl("https://www.nba.com/sixers");
        waitFor(footer);
    }

    public boolean isFooterDisplayed() {
        return driver.findElement(footer).isDisplayed();
    }

    public List<WebElement> getFooterLinks() {
        return driver.findElements(footerLinks);
    }

    public void scrollToFooter() {
        WebElement footerElement = driver.findElement(footer);
        JavascriptExecutor js =
                (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footerElement);
    }
}
