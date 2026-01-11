package com.veeva.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopPage extends BasePage {
    private static final String SHOP_URL = "https://www.nba.com/warriors";
    // ===== Popup (NOT iframe) =====
    private final By popupModal =
            By.cssSelector("div[class*='InsiderPopup_modal']");
    private final By popupClose =
            By.cssSelector("div.p-2.absolute.right-3");

    // ===== Menu =====
    private final By shopMenu = By.xpath("//a[contains(text(),'Shop')]");
    private final By mensMenu = By.xpath("//a[contains(text(),\"Men's\")]");
    private final By jacketsLink = By.xpath("//a[contains(text(),'Jackets')]");

    // ===== Products =====
    private final By productCards = By.cssSelector(".product-card, .product-item");
    private final By productTitle = By.cssSelector("h3, .product-item-name");
    private final By productPrice = By.cssSelector(".price");

    // ===== Pagination =====
    private final By nextPage = By.cssSelector("[aria-label='Next Page']");

    public void openWarriorsHome() {
        openUrl(SHOP_URL);
        closePopupIfPresent();
    }

    private void closePopupIfPresent() {
        try {
            waitFor(popupModal);
            click(popupClose);
            wait.until(driver -> !isPresent(popupModal));
        } catch (Exception ignored) {
            // popup may not appear every time — SAFE IGNORE
        }
    }

    public void openMensJackets() {
        click(shopMenu);
        click(mensMenu);
        click(jacketsLink);
    }

    public List<WebElement> getProducts() {
        return driver.findElements(productCards);
    }

    public String getTitle(WebElement product) {
        return product.findElement(productTitle).getText().trim();
    }

    public String getPrice(WebElement product) {
        return product.findElement(productPrice).getText().trim();
    }

    public boolean hasNextPage() {
        return driver.findElements(nextPage).size() > 0;
    }

    public void goNextPage() {
        click(nextPage);
    }
}
