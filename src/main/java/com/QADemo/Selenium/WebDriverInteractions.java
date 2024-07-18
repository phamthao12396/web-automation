package com.QADemo.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverInteractions {
    private RemoteWebDriver driver;
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);

    public WebDriverInteractions(RemoteWebDriver driver) {
        this.driver = driver;
    }

    /**
     * open a url
     *
     * @param url the given url
     */
    public void openUrl(String url){
        driver.get(url);
    }

    public String getWindowTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageSource(){
        return driver.getPageSource();
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void goForwardPage(){
        driver.navigate().forward();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
}
