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

    public void navigateToUrl(String url){
        logger.info("Navigate to URL "+ url);
        driver.get(url);
    }

    public void navigateToElement(){
        logger.info("Navigate to QADemo - Element");
        navigateToUrl(Constant.QADEMO_URL + "elements");
    }

    public void navigateToForms(){
        logger.info("Navigate to QADemo - Forms");
        navigateToUrl(Constant.QADEMO_URL + "forms");
    }

    public void navigateToAlertsWindows(){
        logger.info("Navigate to QADemo - Alerts, Frame & Windows");
        navigateToUrl(Constant.QADEMO_URL + "alertsWindows");
    }
}
