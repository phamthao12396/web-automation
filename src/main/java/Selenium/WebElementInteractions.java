package Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementInteractions {
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);
    private WebElementWaits webElementWaits;
    private WebDriverInteractions webDriverInteractions;
    private WebElementLocator webElementLocator;
    private SwitchToPopUp switchToPopUp;

    public WebElementInteractions(RemoteWebDriver driver, WebDriverWait wait) {
        webElementWaits = new WebElementWaits(wait);
        webDriverInteractions = new WebDriverInteractions(driver);
        webElementLocator = new WebElementLocator(driver);
        switchToPopUp = new SwitchToPopUp(driver);
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

    public String getAttributeFromWebElement(WebElement element, String checked) {
        //add action
        return checked;
    }
}
