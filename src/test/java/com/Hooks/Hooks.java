package com.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utils.WebDriverManage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setup() {
        System.out.println("Scenario Execution Started...");
        driver = WebDriverManage.getDriver();  // Store the driver reference
    }

    @After
    public void tearDown() {
        System.out.println("Scenario Execution Completed...");
        try {
            WebDriverManage.quitDriver();  // Quit the static driver
            System.out.println("Driver quit successfully.");
        } catch (Exception e) {
            System.out.println("Error quitting driver: " + e.getMessage());
        }
    }
    
    @AfterStep
    public void addScreenShots(Scenario scenario) {
    	if(scenario.isFailed()) {

    		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Attach to the scenario
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
    		
    	}
    	
    }

}
