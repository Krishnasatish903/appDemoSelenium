package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManage {

     private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
    	//checking the driver instance
        if (driver.get() == null) {
            try {
                System.out.println("Initializing new WebDriver for thread: " + Thread.currentThread().getId());
                WebDriver newDriver = new ChromeDriver();
                newDriver.manage().window().maximize();
                newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                //seting the driver 
                driver.set(newDriver);
            } catch (WebDriverException e) {
                System.err.println("Failed to initialize WebDriver for thread " + Thread.currentThread().getId() + ": " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("Reusing WebDriver for thread: " + Thread.currentThread().getId());
        }
        return driver.get();
    }

    public static void quitDriver() {
        WebDriver threadDriver = driver.get();
        if (threadDriver != null) {
            try {
                System.out.println("Quitting WebDriver for thread: " + Thread.currentThread().getId());
                threadDriver.quit();
            } catch (WebDriverException e) {
                System.err.println("Error quitting WebDriver for thread " + Thread.currentThread().getId() + ": " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}
