package com.QADemo.pageUIs;

import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementLocator;
import com.QADemo.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementPageUIs {
    private WebElementLocator webElementLocator;
    private WebElementWaits webElementWaits;
    private WebElementInteractions webElementInteractions;
    public ElementPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementLocator = new WebElementLocator(driver);
        webElementWaits = new WebElementWaits(wait);
        webElementInteractions = new WebElementInteractions(driver, wait);
    }
    public WebElement menuTabByName(String tabName){
        return webElementLocator.findElementByXpath("//div[@class='left-pannel']//span[@class='text' and text()='"+tabName+"']");
    }

    public WebElement titleByName(String name){
        return webElementWaits.waitForElementVisibleByXpath("//h1[@class='text-center' and text()='"+name+"']");
    }

    public WebElement textBoxById(String id){
        return webElementLocator.findElementByXpath("//Form[@id='userForm']//input[@id='"+id+"']");
    }
    public WebElement textareaById(String id){
        return webElementLocator.findElementByXpath("//Form[@id='userForm']//textarea[@id='"+id+"']");
    }

    public WebElement submitButton(){
        return webElementLocator.findElementByXpath("//Form[@id='userForm']//button[@id='submit']");
    }

    public WebElement outputById(String id){
        return webElementLocator.findElementByXpath("//div[@id='output']//p[@id='"+id+"']");
    }
}
