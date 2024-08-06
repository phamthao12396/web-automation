package com.QADemo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebElementLocator {
    private RemoteWebDriver driver;

    public WebElementLocator(RemoteWebDriver driver) {
        this.driver = driver;
    }
    /**
     * method to find Element by given xpath
     *
     * @return web element
     */
    public WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public  WebElement findElementById(String id){
        return  driver.findElement(By.id(id));
    }
}
