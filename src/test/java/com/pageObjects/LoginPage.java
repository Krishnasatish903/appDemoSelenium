package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utils.WebActions;

public class LoginPage extends WebActions {
    public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super (driver);
	}
	
	By usernameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By dashBoardText = By.xpath("//span[@class='oxd-topbar-header-breadcrumb'] //h6[text()='Dashboard']");
    By invalidText = By.xpath("//p[text()='Invalid credentials']");

    public void loginToApplication(String userName, String password) {
    	enterText(usernameField,userName);
    	enterText(passwordField,password);
    	click(loginButton);
    }
    
    public void dashBoardText(String result) {
    	String dashBoard = getText(dashBoardText);
        Assert.assertEquals(dashBoard, result);
    }
    
    public void invalidCredentials(String result) {
    	String errorMessage = getText(invalidText);
        Assert.assertEquals(errorMessage, result);
    }
    


}
