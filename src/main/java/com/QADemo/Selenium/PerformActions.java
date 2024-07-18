package com.QADemo.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PerformActions {
    private Actions actions;
    private static final Logger logger = Logger.getLogger(PerformActions.class);

    public PerformActions(RemoteWebDriver driver) {
        actions = new Actions(driver);
    }
}
