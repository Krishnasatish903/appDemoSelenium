package com.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.pageObjects.DashBoard;
import com.pageObjects.LoginPage;
import com.utils.WebDriverManage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dashBoardDefinition {

    public WebDriver driver;
	public DashBoard dashBoard;
    public LoginPage loginPage;

    public dashBoardDefinition() {
        this.driver = WebDriverManage.getDriver();
        this.loginPage = new LoginPage(driver);
        this.dashBoard = new DashBoard(driver);
    }

    @Given("User navigates to the PIM module")
    public void navigateToPim(){
        dashBoard.clickPim();
        
    } 
    @When("User enters employee ID {string} in the search field")
    public void pimEnterEmployID(String ID){
        dashBoard.pimEmpSearch(ID);
    }
@Then("Employee details related to {string} should be displayed")

public void pimEmployeeResult(String ID){
    dashBoard.dashBoardResult(ID);
}

}
