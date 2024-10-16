package com.nopEcommerce.pageUIs;

import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.WritableByteChannel;

public class RegisterPageUIs {
    private WebElementInteractions webElementInteractions;
    private WebElementWaits webElementWaits;
    public RegisterPageUIs(RemoteWebDriver driver, WebDriverWait wait) {
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementWaits = new WebElementWaits(wait);
    }
    public WebElement registerBtn_header(){
        return webElementWaits.waitForElementClickableByXpath("//div[@class='header-links']//a[@class='ico-register']");
    }

    public String registerText(){
        return  webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//div[@class='page-title']/h1"));
    }

    public String errorMessages(){
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleById("FirstName-error"));
    }
}
