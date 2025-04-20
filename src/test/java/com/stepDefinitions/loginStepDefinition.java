package com.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.pageObjects.LoginPage;
import com.utils.WebDriverManage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {
    public WebDriver driver;
	public LoginPage loginPage;
	
	public loginStepDefinition() {
        this.driver = WebDriverManage.getDriver();
        this.loginPage = new LoginPage(driver);
    }
	
	@Given("I am on the Login Page")
	public void loginPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user enters username {string} and password {string}")
	public void userNameAndPassword(String username, String password) {
	  loginPage.loginToApplication(username, password);
	  
	}
	@Then("I should see {string}")
	public void loginValidation(String result ) {
		if(result.equalsIgnoreCase("DashBoard")) {
			loginPage.dashBoardText(result);
		}else {
		loginPage.invalidCredentials(result);
		}
	}


}
