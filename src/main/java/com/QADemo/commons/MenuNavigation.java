package com.QADemo.commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MenuNavigation {
    private static final Logger logger = Logger.getLogger(MenuNavigation.class);

    private final RemoteWebDriver driver;

    public MenuNavigation(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToUrl(URL url){
        logger.info("Navigate to URL "+ url);
        driver.get(url.toString());
    }

}
