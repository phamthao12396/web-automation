package com.QADemo.pageUIs;

import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementLocator;
import com.QADemo.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesPageUIs {
    private WebElementLocator webElementLocator;
    private WebElementInteractions webElementInteractions;
    private WebElementWaits webElementWaits;
    public WebTablesPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementLocator = new WebElementLocator(driver);
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementWaits = new WebElementWaits(wait);
    }
    public WebElement addBtn(){
        return  webElementLocator.findElementById("addNewRecordButton");
    }

    public String registrationFormTitle(){
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//div[@class='modal-header']/div"));
    }

    public WebElement firstNameTBx(){
        return webElementLocator.findElementById("firstName");
    }

    public WebElement lastNameTbx(){
        return webElementLocator.findElementById("lastName");
    }

    public WebElement emailTBx(){
        return  webElementLocator.findElementById("userEmail");
    }

    public WebElement ageTBx(){
        return webElementLocator.findElementById("age");
    }

    public  WebElement salaryTBx(){
        return webElementLocator.findElementById("salary");
    }

    public WebElement departmentTBx(){
        return  webElementLocator.findElementById("department");
    }

    public WebElement submitBtn(){
        return webElementLocator.findElementById("submit");
    }

    public WebElement searchTBx(){
        return webElementWaits.waitForElementVisibleById("searchBox");
    }
}
