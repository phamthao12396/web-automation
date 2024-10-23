package com.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class SwitchToPopUp {
    private WebDriver driver;
    private WebDriverInteractions webDriverInteractions;
    private static final Logger logger = Logger.getLogger(WebElementInteractions.class);

    public SwitchToPopUp(RemoteWebDriver driver) {
        this.driver = driver;
        webDriverInteractions = new WebDriverInteractions(driver);
    }

    public String getWindownHandle(){
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    /**
     * Switch to window by passing window handler
     *
     * @param window handler
     */
    public void switchToWin(String window) {
        logger.info("        Switching to Window: " + driver.switchTo().window(window).getTitle());
        driver.switchTo().window(window);
        webDriverInteractions.maximizeWindow();
    }

    /**
     * switch to parent window by given parent window handler
     *
     * @param parentWindow value
     */
    public void switchToParentWin(String parentWindow) throws InterruptedException {
        switchToWin(parentWindow);
        Thread.sleep(2000);
    }
}
