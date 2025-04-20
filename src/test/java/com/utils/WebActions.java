package com.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebActions {

     protected WebDriver driver;

	    public WebActions(WebDriver driver) {
	        this.driver = driver;
	    }
	    //Type the Text 
	    public void enterText(By locator, String text) {
	    	driver.findElement(locator).sendKeys(text);
	    }
	    //Click the element
	    public void click(By locator) {
	        driver.findElement(locator).click();
	    }
	    public String getText(By locator) {
	    	return driver.findElement(locator).getText();
	    }
	    //Handling Alerts
	    public Alert switchToAlert() {
	    	return driver.switchTo().alert();
	    }
	    //accept alert
	    public void acceptAlert() {
	    	switchToAlert().accept();
	    }
	    
	    
	    

}
