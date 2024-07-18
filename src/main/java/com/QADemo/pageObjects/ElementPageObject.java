package com.QADemo.pageObjects;

import com.QADemo.Selenium.TextInputElement;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementWaits;
import com.QADemo.pageUIs.ElementPageUIs;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementPageObject {
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);
    private WebElementWaits webElementWaits;
    private WebElementInteractions webElementInteractions;
    private ElementPageUIs elementPageUIs;
    private TextInputElement textInputElement;
    public ElementPageObject(RemoteWebDriver driver, WebDriverWait wait){
        webElementWaits = new WebElementWaits(wait);
        webElementInteractions= new WebElementInteractions(driver, wait);
        elementPageUIs = new ElementPageUIs(driver, wait);
        textInputElement= new TextInputElement(driver, wait);
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
    public void sendKeysToForm(String fullName, String Email, String currentAddress, String permanentAddress){
        textInputElement.sendKeys(elementPageUIs.textBoxById("userName"), fullName);
        textInputElement.sendKeys(elementPageUIs.textBoxById("userEmail"), fullName);
        textInputElement.sendKeys(elementPageUIs.textBoxById("currentAddress"), fullName);
        textInputElement.sendKeys(elementPageUIs.textBoxById("permanentAddress"), fullName);
    }
    public void clickSubmitButton(){
        webElementInteractions.clickOnElement(elementPageUIs.submitButton());
    }

    public void verifyDataDisplayedMatchWithGivenData(String fullName, String Email, String currentAddress, String permanentAddress){
        String name= webElementInteractions.getTextFromWebElement(elementPageUIs.outputById("name"));
    }
}
