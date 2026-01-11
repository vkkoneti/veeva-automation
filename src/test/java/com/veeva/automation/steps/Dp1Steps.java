package com.veeva.automation.steps;

import com.veeva.automation.pages.Dp1HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Dp1Steps {

    private final Dp1HomePage dp1 = new Dp1HomePage();

    @When("I open DP1 home page")
    public void openDp1() {
        dp1.openDp1HomePage();
    }

    @Then("I validate DP1 carousel slides")
    public void validateSlides() {

        List<WebElement> slides = dp1.getSlides();

        Assert.assertTrue(slides.size() > 0,
                "No slides found in DP1 carousel");

        for (WebElement slide : slides) {
            String label = dp1.getSlideLabel(slide);

            Assert.assertNotNull(label, "Slide aria-label missing");
            Assert.assertTrue(label.contains("/"),
                    "Invalid slide label: " + label);
        }

        System.out.println("DP1 slides validated. Total slides = " + slides.size());
    }
}
