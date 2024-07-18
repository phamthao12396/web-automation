package com.QADemo.pageUIs;

import com.QADemo.Selenium.WebElementLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementPageUIs {
    private WebElementLocator webElementLocator;
    public ElementPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementLocator = new WebElementLocator(driver);
    }

    public WebElement buttonByName(String name){
        return webElementLocator.findElementByXpath(""+name);
    }
}
