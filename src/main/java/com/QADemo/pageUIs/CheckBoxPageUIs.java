package com.QADemo.pageUIs;

import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementLocator;
import com.QADemo.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPageUIs {
    private WebElementLocator webElementLocator;
    private WebElementWaits webElementWaits;
    private WebElementInteractions webElementInteractions;
    public CheckBoxPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementLocator = new WebElementLocator(driver);
        webElementWaits = new WebElementWaits(wait);
        webElementInteractions = new WebElementInteractions(driver, wait);
    }

    public WebElement homeExpanseIcon(){
        return webElementLocator.findElementByXpath("//button[@title='Toggle']");
    }

    public  WebElement expandByCheckBoxText(String checkboxName){
        return webElementLocator.findElementByXpath("//span[@class='rct-title' and text()='"+checkboxName+"']//parent::label//preceding::button[@title='Toggle']");
    }
}
