package com.nopEcommerce.Commons;

import com.nopEcommerce.pageObjects.RegisterPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGeneratorManager {
    public static RegisterPageObject getRegisterPageObject(RemoteWebDriver driver, WebDriverWait wait){
        return new RegisterPageObject(driver, wait);
    }

}
