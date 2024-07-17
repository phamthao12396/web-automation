package Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown {
    private static final Logger logger = Logger.getLogger(SelectDropDown.class);
    private WebElementInteractions webElementInteractions;
    private WebElementLocator webElementLocator;
    private TextInputElement textInputElement;
    private PerformActions performActions;

    public SelectDropDown(RemoteWebDriver driver, WebDriverWait wait) {
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementLocator = new WebElementLocator(driver);
        textInputElement = new TextInputElement(driver, wait);
        performActions = new PerformActions(driver);
    }
}
