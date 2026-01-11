package com.veeva.automation.steps;

import com.veeva.automation.pages.Dp1HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class Dp1Steps {

    private final Dp1HomePage dp1HomePage = new Dp1HomePage();

    private int slideCount;
    private List<String> slideTitles;
    private long slideDuration;

    @Given("I open DP1 home page")
    public void openDP1HomePage() {
        dp1HomePage.open();
    }

    @When("I capture all slider details")
    public void captureSliderDetails() {
        slideCount = dp1HomePage.getSlideCount();
        slideTitles = dp1HomePage.getSlideTitles();
        slideDuration = dp1HomePage.getSlideDurationInSeconds();
    }

    @Then("slider count, titles and duration should be valid")
    public void validateSliderData() {

        Assert.assertTrue(slideCount > 0,
                "Slider count should be greater than zero");

        for (String title : slideTitles) {
            Assert.assertFalse(title.isEmpty(),
                    "Slide title should not be empty");

        }

        Assert.assertTrue(slideDuration > 0,
                "Slide duration should be greater than zero");

        // Optional expected duration validation
        Assert.assertTrue(slideDuration >= 3,
                "Slide duration should be at least 3 seconds");
    }
}
