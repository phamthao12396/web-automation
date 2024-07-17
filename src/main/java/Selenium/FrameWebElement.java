package Selenium;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameWebElement {
    RemoteWebDriver driver;
    WebElementWaits webElementWaits;
    public FrameWebElement(RemoteWebDriver driver, WebDriverWait  wait){
        this.driver = driver;
        webElementWaits = new WebElementWaits(wait);
    }
}
