package com.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextInputElement {
    private static final Logger logger = Logger.getLogger(TextInputElement.class);
    private WebDriverInteractions webDriverInteractions;
    private WebElementLocator webElementLocator;
    private WebElementInteractions webElementInteractions;

    public TextInputElement(RemoteWebDriver driver, WebDriverWait wait) {
        webDriverInteractions = new WebDriverInteractions(driver);
        webElementLocator = new WebElementLocator(driver);
        webElementInteractions = new WebElementInteractions(driver, wait);
    }
    /**
     * send given value to the web element
     *
     * @param element web element
     * @param value given value
     */
    public void sendKeys(WebElement element, String value){
        element.sendKeys(value);
        logger.info("  Entered value "+ value);
    }

    /**
     * press the given key on the web element
     *
     * @param element given web element
     * @param  keys keys to press
     */
    public void pressKeys(WebElement element, Keys keys){
        element.sendKeys(keys);
        logger.info("  Pressed key "+keys);
    }

    /**
     * clear text input element
     *
     * @param element the given web element
     */
    public void clearElementText(WebElement element){
        element.clear();
    }

    /**
     * method to send given Keys with tab
     *
     * @param  value to send
     * @param  element textbox
     */
    public void sendKeysWithTab(WebElement element, String value) {
        sendKeys(element,value);
        pressKeys(element, Keys.TAB);
    }

    /**
     * method to send given Keys with tab and clear
     *
     * @param  value to send
     * @param  element textbox
     */
    public void sendKeysWithClearAndTab(WebElement element, String value) {
        clearElementText(element);
        sendKeys(element,value);
        pressKeys(element, Keys.TAB);
    }
}
