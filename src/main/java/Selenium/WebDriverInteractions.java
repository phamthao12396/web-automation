package Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverInteractions {
    private RemoteWebDriver driver;
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);

    public WebDriverInteractions(RemoteWebDriver driver) {
        this.driver = driver;
    }
}
