package com.QADemo.Selenium;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableWebElement {
    RemoteWebDriver driver;
    WebElementWaits webElementWaits;

    public TableWebElement(RemoteWebDriver driver, WebDriverWait wait){
        this.driver =driver;
        webElementWaits = new WebElementWaits(wait);
    }
}
