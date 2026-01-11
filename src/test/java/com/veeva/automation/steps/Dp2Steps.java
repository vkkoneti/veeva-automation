package com.veeva.automation.steps;

import com.veeva.automation.pages.Dp2HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Dp2Steps {

    private final Dp2HomePage dp2 = new Dp2HomePage();

    @When("I open DP2 home page")
    public void openDp2HomePage() {
        dp2.openDp2HomePage();
        dp2.scrollToFooter();
    }

    @Then("I validate DP2 footer section")
    public void validateFooter() {

        Assert.assertTrue(dp2.isFooterDisplayed(),
                "Footer is not displayed");

        List<WebElement> links = dp2.getFooterLinks();

        Assert.assertTrue(links.size() > 0,
                "Footer links are missing");

        for (WebElement link : links) {
            String text = link.getText().trim();
            String href = link.getAttribute("href");

            Assert.assertFalse(text.isEmpty(),
                    "Footer link text is empty");

            Assert.assertNotNull(href,
                    "Footer link href is missing");
        }

        System.out.println("DP2 Footer validated. Total links = " + links.size());
    }
}
