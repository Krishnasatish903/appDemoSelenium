package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WebActions;

public class DashBoard extends WebActions{
    public WebDriver driver;

    public DashBoard(WebDriver driver){
        super(driver);
    }

    By pimDashboard = By.xpath("//span[text()='PIM']");
    By pimTextDashBoard = By.xpath("//span[@class ='oxd-topbar-header-breadcrumb'] //h6[text()= 'PIM']");
    By employeeIDText = By.xpath("//div[@class ='oxd-grid-item oxd-grid-item--gutters' and .//label[text()='Employee Id']] //div//input[@class='oxd-input oxd-input--active']"); 
    By searchButton = By.xpath("//button[@type='submit']");  
    By pimDashBoardResult =  By.xpath("//div[@class='oxd-table-cell oxd-padding-cell' and .//div[text()= '0007']]");

    public void clickPim(){
    click(pimDashboard);
    expectedString("PIM", pimTextDashBoard);
}

public void pimEmpSearch(String employeeID){
enterText(employeeIDText, employeeID);
click(searchButton);
}

public void dashBoardResult(String employeeID){
    expectedString(employeeID, pimDashBoardResult);
}

}
//---------------------------------------------
