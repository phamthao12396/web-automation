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

    public WebElement waitForElementVisible(String xpath){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public Boolean waitForElementSelected(String xpath){
        return wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
    }

    public WebElement waitForElementClickable(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public Boolean waitForElementInvisible(String xpath){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
}
