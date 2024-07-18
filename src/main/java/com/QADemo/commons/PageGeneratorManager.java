package com.QADemo.commons;

import org.openqa.selenium.WebDriver;
import com.QADemo.pageObjects.ElementPageObject;

public class PageGeneratorManager {
    public static ElementPageObject getRegisterPageObject(WebDriver driver){
        return new ElementPageObject(driver);
    }
}
