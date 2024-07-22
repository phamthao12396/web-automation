package com.QADemo.pageObjects;

import com.QADemo.Selenium.TextInputElement;
import com.QADemo.Selenium.WebDriverInteractions;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.pageUIs.ElementPageUIs;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ElementPageObject {
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);
    private WebElementInteractions webElementInteractions;
    private ElementPageUIs elementPageUIs;
    private TextInputElement textInputElement;
    private WebDriverInteractions webDriverInteractions;
    public ElementPageObject(RemoteWebDriver driver, WebDriverWait wait){
        webElementInteractions= new WebElementInteractions(driver, wait);
        elementPageUIs = new ElementPageUIs(driver, wait);
        textInputElement= new TextInputElement(driver, wait);
        webDriverInteractions = new WebDriverInteractions(driver);
    }

    public void clickToMenuByName(String tabName){
        webElementInteractions.clickOnElement(elementPageUIs.menuTabByName(tabName));
    }

    public void verifyPageTitleDisplayed(String name){
        Boolean flag = webElementInteractions.isDisplayed(elementPageUIs.titleByName(name));
        if (flag) {
            logger.info("Element displayed.");
        }
    }
    public void sendKeysToForm(String fullName, String email, String currentAddress, String permanentAddress){
        textInputElement.sendKeys(elementPageUIs.textBoxById("userName"), fullName);
        textInputElement.sendKeys(elementPageUIs.textBoxById("userEmail"), email);
        textInputElement.sendKeys(elementPageUIs.textareaById("currentAddress"), currentAddress);
        textInputElement.sendKeys(elementPageUIs.textareaById("permanentAddress"), permanentAddress);
    }
    public void clickSubmitButton(){
        webDriverInteractions.scrollToElement(elementPageUIs.submitButton());
        webElementInteractions.clickOnElement(elementPageUIs.submitButton());
    }

    public void verifyDataDisplayedMatchWithGivenData(String fullName, String email, String currentAddress, String permanentAddress){
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(elementPageUIs.outputById("name"))), fullName, "Full Name should be match.");
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(elementPageUIs.outputById("email"))), email, "Email should be match.");
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(elementPageUIs.outputById("currentAddress"))), currentAddress, "Current Address should be match.");
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(elementPageUIs.outputById("permanentAddress"))), permanentAddress, "Permanent Address should be match.");
    }

    public String getTextFromData(String text){
        String[] listText=  text.split(":");
        return listText[1];
    }
}
