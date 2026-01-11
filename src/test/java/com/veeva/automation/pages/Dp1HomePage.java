package com.veeva.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Dp1HomePage extends BasePage {

    // Swiper container
    private final By swiperContainer =
            By.cssSelector("div.swiper.swiper-initialized");

    // All slides
    private final By slides =
            By.cssSelector("div.swiper-slide");

    public void openDp1HomePage() {
        openUrl("https://www.nba.com/bulls"); // DP1 example

        // Wait until swiper loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(swiperContainer));
    }

    public List<WebElement> getSlides() {
        return driver.findElements(slides);
    }

    public String getSlideLabel(WebElement slide) {
        return slide.getAttribute("aria-label");
    }
}
