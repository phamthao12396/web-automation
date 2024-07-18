package com.QADemo.commons;

import org.openqa.selenium.WebDriver;
import com.QADemo.pageObjects.ElementPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGeneratorManager {
    public static ElementPageObject getRegisterPageObject(RemoteWebDriver driver, WebDriverWait waits){
        return new ElementPageObject(driver, waits);
    }
}
