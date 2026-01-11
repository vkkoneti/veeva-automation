package com.veeva.automation.steps;

import com.veeva.automation.pages.ShopPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShopSteps {

    private final ShopPage shopPage = new ShopPage();

    @Given("I open the Warriors home page")
    public void openHome() {
        shopPage.openWarriorsHome();
    }

    @When("I navigate to Shop -> Men's -> Jackets")
    public void navigateToJackets() {
        shopPage.openMensJackets();
    }

    @Then("all jacket products should have title and price")
    public void verifyProducts() {

        boolean hasNext;

        do {
            List<WebElement> products = shopPage.getProducts();
            Assert.assertTrue(products.size() > 0, "No products found on page");

            for (WebElement product : products) {
                String title = shopPage.getTitle(product);
                String price = shopPage.getPrice(product);

                Assert.assertFalse(title.trim().isEmpty(), "Product title missing");
                Assert.assertFalse(price.trim().isEmpty(), "Product price missing");
            }

            hasNext = shopPage.hasNextPage();
            if (hasNext) {
                shopPage.goNextPage();
            }

        } while (hasNext);
    }
}
