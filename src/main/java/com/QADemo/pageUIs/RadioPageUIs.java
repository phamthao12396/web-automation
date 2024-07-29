package com.QADemo.pageUIs;

import com.QADemo.Selenium.WebDriverInteractions;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementLocator;
import com.QADemo.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioPageUIs {
    private WebElementWaits webElementWaits;
    public RadioPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementWaits = new WebElementWaits(wait);
    }

    public WebElement radioButtonByName(String name){
        return webElementWaits.waitForElementClickableByXpath("//label[text()='"+name+"']/preceding::input[1]");
    }

    public WebElement resultText(){
        return webElementWaits.waitForElementVisibleByXpath("//span[@class='text-success']");
    }
}
