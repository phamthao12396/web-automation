package com.QADemo.pageObjects;

import com.QADemo.Selenium.WebDriverInteractions;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.pageUIs.RadioPageUIs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RadioPageObjects {
    RemoteWebDriver driver;
    private RadioPageUIs radioPageUIs;
    private WebElementInteractions webElementInteractions;
    private WebDriverInteractions webDriverInteractions;
    public RadioPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        webElementInteractions = new WebElementInteractions(driver,wait);
        webDriverInteractions = new WebDriverInteractions(driver);
        radioPageUIs = new RadioPageUIs(driver, wait);
    }

    public void clickToRadioButtonByName(String radioName) {
        webDriverInteractions.scrollToElement(radioPageUIs.radioButtonByName(radioName));
        webElementInteractions.clickOnElement(radioPageUIs.radioButtonByName(radioName));
    }

    public void verifyTheTextDisplayedMatchWithRadioButtonSelected(String radioName) {
        Assert.assertTrue(webElementInteractions.getTextFromWebElement(radioPageUIs.resultText()).equalsIgnoreCase(radioName));
    }
}
