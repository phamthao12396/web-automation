package com.nopEcommerce.Commons;

import com.Selenium.WebElementInteractions;
import com.nopEcommerce.pageObjects.RegisterPageObject;
import com.nopEcommerce.pageUIs.RegisterPageUIs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigation {
    private WebElementInteractions webElementInteractions;
    private RegisterPageUIs registerPageUIs;
    public Navigation(RemoteWebDriver driver, WebDriverWait wait) {
        webElementInteractions = new WebElementInteractions(driver, wait);
        registerPageUIs = new RegisterPageUIs(driver, wait);
    }

    public RegisterPageObject navigateToRegisterPage(RemoteWebDriver driver, WebDriverWait wait){
        webElementInteractions.clickOnElement(registerPageUIs.registerBtn_header());
        return new RegisterPageObject(driver, wait);
    }
}
