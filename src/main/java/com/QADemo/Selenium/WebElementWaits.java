package com.QADemo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWaits {
    WebDriverWait wait;
    public WebElementWaits(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement waitForElementVisibleByXpath(String xpath){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement waitForElementVisibleById(String id){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public Boolean waitForElementSelectedByXpath(String xpath){
        return wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
    }
    public Boolean waitForElementSelectedById(String id){
        return wait.until(ExpectedConditions.elementToBeSelected(By.id(id)));
    }

    public WebElement waitForElementClickableByXpath(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public WebElement waitForElementClickableById(String id){
        return wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public Boolean waitForElementInvisibleByXpath(String xpath){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
    public Boolean waitForElementInvisibleById(String id){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }
}
