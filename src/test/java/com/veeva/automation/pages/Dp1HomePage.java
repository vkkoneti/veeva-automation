package com.veeva.automation.pages;

import com.veeva.automation.config.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Dp1HomePage extends BasePage {

    // ===== URL =====
    //private static final String DP1_URL = "https://www.nba.com/bulls";
    private static final String DP1_URL =  ConfigReader.get("base.url.dp1");

    // ===== Slider Locators =====
    private final By sliderRoot = By.cssSelector("div.swiper");
    private final By sliderWrapper = By.cssSelector("div.swiper-wrapper");
    private final By slides = By.cssSelector("div.swiper-slide");
    private final By slideTitle = By.cssSelector("h3, h2");


    // ===== Constructor =====
    public Dp1HomePage() {
        super();
    }

    // ===== Actions =====
    public void open() {
        driver.get(DP1_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sliderRoot));
    }

    public int getSlideCount() {
        return driver.findElements(slides).size();
    }

    public List<String> getSlideTitles() {
        List<String> titles = new ArrayList<>();
        List<WebElement> slideElements = driver.findElements(slides);

        for (WebElement slide : slideElements) {
            try {
                String text = slide.findElement(slideTitle).getText().trim();
                titles.add(text);
            } catch (NoSuchElementException e) {
                titles.add("NO_TITLE_FOUND");
            }
        }
        return titles;
    }

    public long getSlideDurationInSeconds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Swiper stores autoplay delay internally
        Object delay = js.executeScript(
                "return document.querySelector('.swiper')?.swiper?.params?.autoplay?.delay;"
        );

        if (delay == null) {
            return -1;
        }
        return Long.parseLong(delay.toString()) / 1000;
    }
}
