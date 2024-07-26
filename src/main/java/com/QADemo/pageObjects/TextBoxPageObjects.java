package com.QADemo.pageObjects;

import com.QADemo.Selenium.TextInputElement;
import com.QADemo.Selenium.WebDriverInteractions;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.commons.PageGeneratorManager;
import com.QADemo.pageUIs.TextBoxPageUIs;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TextBoxPageObjects {
    private static final Logger logger = Logger.getLogger(TextBoxPageObjects.class);
    public static final String TEXTBOX_TAB = "Text Box";
    private WebElementInteractions webElementInteractions;
    private TextBoxPageUIs textBoxPageUIs;
    private TextInputElement textInputElement;
    private WebDriverInteractions webDriverInteractions;
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    public TextBoxPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        webElementInteractions= new WebElementInteractions(driver, wait);
        textBoxPageUIs = new TextBoxPageUIs(driver, wait);
        textInputElement= new TextInputElement(driver, wait);
        webDriverInteractions = new WebDriverInteractions(driver);
    }

    public void clickToTextBoxTab(){
        webElementInteractions.clickOnElement(textBoxPageUIs.menuTabByName(TEXTBOX_TAB));
    }

    public CheckBoxPageObjects clickToCheckBoxTab(){
        webElementInteractions.clickOnElement(textBoxPageUIs.menuTabByName("Check Box"));
        return PageGeneratorManager.getCheckBoxPageObjects(driver, wait);
    }

    public void verifyPageTitleDisplayed(){
        Boolean flag = webElementInteractions.isDisplayed(textBoxPageUIs.titleByName(TEXTBOX_TAB));
        if (flag) {
            logger.info("Element displayed.");
        }
    }
    public void sendKeysToForm(String fullName, String email, String currentAddress, String permanentAddress){
        textInputElement.sendKeys(textBoxPageUIs.textBoxById("userName"), fullName);
        textInputElement.sendKeys(textBoxPageUIs.textBoxById("userEmail"), email);
        textInputElement.sendKeys(textBoxPageUIs.textareaById("currentAddress"), currentAddress);
        textInputElement.sendKeys(textBoxPageUIs.textareaById("permanentAddress"), permanentAddress);
    }
    public void clickSubmitButton(){
        webDriverInteractions.scrollToElement(textBoxPageUIs.submitButton());
        webElementInteractions.clickOnElement(textBoxPageUIs.submitButton());
    }

    public void verifyDataDisplayedMatchWithGivenData(String fullName, String email, String currentAddress, String permanentAddress){
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(textBoxPageUIs.outputById("name"))), fullName, "Full Name should be match.");
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(textBoxPageUIs.outputById("email"))), email, "Email should be match.");
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(textBoxPageUIs.outputById("currentAddress"))), currentAddress, "Current Address should be match.");
        Assert.assertEquals(getTextFromData(webElementInteractions.getTextFromWebElement(textBoxPageUIs.outputById("permanentAddress"))), permanentAddress, "Permanent Address should be match.");
    }

    public String getTextFromData(String text){
        String[] listText=  text.split(":");
        return listText[1];
    }
}
