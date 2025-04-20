package com.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
			waitForElementVisible(locator, 10);
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
		public void expectedString(String Expected, By locator){
			String actualText = driver.findElement(locator).getText();
			Assert.assertEquals(actualText, Expected);
		}
		
		 public void waitForElementVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
 

}
