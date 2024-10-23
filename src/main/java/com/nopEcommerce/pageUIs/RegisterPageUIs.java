package com.nopEcommerce.pageUIs;

import com.Selenium.WebElementInteractions;
import com.Selenium.WebElementLocator;
import com.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageUIs {
    private WebElementInteractions webElementInteractions;
    private WebElementWaits webElementWaits;
    private WebElementLocator webElementLocator;

    public RegisterPageUIs(RemoteWebDriver driver, WebDriverWait wait) {
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementWaits = new WebElementWaits(wait);
        webElementLocator = new WebElementLocator(driver);
    }

    public WebElement registerBtn_header() {
        return webElementWaits.waitForElementClickableByXpath("//div[@class='header-links']//a[@class='ico-register']");
    }

    public String registerText() {
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//div[@class='page-title']/h1"));
    }

    public String firstNameError() {
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementPresentById("FirstName-error"));
    }

    public WebElement registerButton() {
        return webElementLocator.findElementById("register-button");
    }

    public String lastNameError() {
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementPresentById("LastName-error"));
    }

    public String emailError() {
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementPresentById("Email-error"));
    }

    public String passwordError() {
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementPresentById("ConfirmPassword-error"));
    }

    public WebElement firstNameTxt() {
        return webElementLocator.findElementById("FirstName");
    }

    public WebElement lastNameTxt() {
        return webElementLocator.findElementById("LastName");
    }

    public WebElement emailTxt() {
        return webElementLocator.findElementById("Email");
    }

    public WebElement passwordTxt() {
        return webElementLocator.findElementById("Password");
    }

    public WebElement confirmPasswordTxt() {
        return webElementLocator.findElementById("ConfirmPassword");
    }

    public String successRegisterMessage(){
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//div[@class='result']"));
    }

    public String validationError(){
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//div[@class='message-error validation-summary-errors']/ul/li"));
    }

    public String passwordLessThan6CharactersErrorMessage(){
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//input[@id='Password']/parent::div//span[@class='field-validation-error']"));
    }
}
