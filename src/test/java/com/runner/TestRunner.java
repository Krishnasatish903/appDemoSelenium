package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/resources/features/pimPage.feature",
glue = {"com.stepDefinitions", "com.Hooks"},
monochrome = true, plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html"
    }
)

public class TestRunner extends AbstractTestNGCucumberTests {
    //To run the scenarios parallel- if having only one feature file we can use below
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}


}
