package com.veeva.automation.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.veeva.automation.driver.DriverFactory;
import com.veeva.automation.reporting.ExtentManager;
import com.veeva.automation.reporting.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static ExtentReports extent = ExtentManager.getExtent();

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("HOOK EXECUTED..");
        //  Create Extent test for scenario
        ExtentTest test = extent.createTest(scenario.getName());
        ExtentTestManager.setTest(test);

        //  Read browser from JVM argument
        String browser = System.getProperty("browser", "chrome");

        //  Initialize browser
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {

        //  Update Extent status
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Scenario Failed");
        } else {
            ExtentTestManager.getTest().pass("Scenario Passed");
        }

        // Quit browser
        DriverFactory.quitDriver();

        // Cleanup Extent
        ExtentTestManager.unload();
        extent.flush();
    }
}
