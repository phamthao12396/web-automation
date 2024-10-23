package com.QADemo.pageUIs;

import com.Selenium.WebElementLocator;
import com.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioPageUIs {
    private WebElementWaits webElementWaits;
    private WebElementLocator webElementLocator;
    public RadioPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementWaits = new WebElementWaits(wait);
        webElementLocator = new WebElementLocator(driver);
    }

    public WebElement radioButtonByName(String name){
        return webElementLocator.findElementByXpath("//label[text()='"+name+"']");
    }

    public WebElement resultText(){
        return webElementWaits.waitForElementVisibleByXpath("//span[@class='text-success']");
    }
}
