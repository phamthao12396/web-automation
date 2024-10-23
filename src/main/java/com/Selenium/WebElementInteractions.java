package com.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementInteractions {
    private RemoteWebDriver driver;
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);
    WebElementWaits webElementWaits;

    public WebElementInteractions(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        webElementWaits = new WebElementWaits(wait);
    }

    /**
     * Click on the given web element
     *
     * @param element web element
     */
    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * get text from the given web element
     *
     * @param element web element
     * @return String text
     */
    public String getTextFromWebElement(WebElement element) {
        return element.getText();
    }

    /**
     * get value from the given attribute of web element
     *
     * @param element web element
     * @param attribute the attribute
     * @return String text
     */
    public String getAttributeFromWebElement(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * checks if element is displayed
     *
     * @param element web element
     * @return true if element is displayed
     */
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * checks if element is enabled
     *
     * @param element web element
     * @return true if element is enabled
     */
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Get value in input tag
     *
     * @param inputElement web element
     * @return attribute value
     */
    public String getInputValue(WebElement inputElement) {
        return getAttributeFromWebElement(inputElement, "value");
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
