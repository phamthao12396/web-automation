package com.QADemo.commons;

import com.QADemo.Selenium.WebElementWaits;
import com.QADemo.pageObjects.CheckBoxPageObjects;
import com.QADemo.pageObjects.TextBoxPageObjects;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGeneratorManager {
    WebElementWaits webElementWaits;
    RemoteWebDriver driver;
    public  PageGeneratorManager(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        webElementWaits = new WebElementWaits(wait);
    }

    public static TextBoxPageObjects getTextBoxPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        return new TextBoxPageObjects(driver, wait);
    }
    public static CheckBoxPageObjects getCheckBoxPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        return new CheckBoxPageObjects(driver, wait);
    }
}
