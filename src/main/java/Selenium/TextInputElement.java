package Selenium;

import org.apache.log4j.Logger;
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
     * method to send given Keys with tab
     *
     * @param  value to send
     * @param  element textbox
     */
    public void sendKeysWithTab(WebElement element, String value) {
    }
}