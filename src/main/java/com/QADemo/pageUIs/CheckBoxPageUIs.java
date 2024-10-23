package com.QADemo.pageUIs;

import com.Selenium.WebElementInteractions;
import com.Selenium.WebElementLocator;
import com.Selenium.WebElementWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPageUIs {
    private WebElementLocator webElementLocator;
    private WebElementWaits webElementWaits;
    private WebElementInteractions webElementInteractions;
    public CheckBoxPageUIs(RemoteWebDriver driver, WebDriverWait wait){
        webElementLocator = new WebElementLocator(driver);
        webElementWaits = new WebElementWaits(wait);
        webElementInteractions = new WebElementInteractions(driver, wait);
    }

    public WebElement expandButton() {
        return webElementWaits.waitForElementClickableByXpath("//div[@id='tree-node']//button[@title='Expand all']");
    }

    public WebElement checkBoxByName(String checkboxName){
        return webElementWaits.waitForElementClickableByXpath("//span[@class='rct-checkbox'][following-sibling::span[text()='"+checkboxName+"']]");
    }

    public String selectedResult(){
        return webElementInteractions.getTextFromWebElement(webElementWaits.waitForElementVisibleByXpath("//div[@id='result']/span[@class='text-success']"));
    }
}
