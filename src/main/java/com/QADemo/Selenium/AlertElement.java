package com.QADemo.Selenium;


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AlertElement {
    private static final Logger logger = Logger.getLogger(AlertElement.class);
    private final RemoteWebDriver driver;

    public AlertElement(RemoteWebDriver driver) {
        this.driver = driver;
    }

    /**
     * switch to alert message
     *
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * get alert text
     *
     * @param alert object
     * @return alert message
     */
    public String getAlertText(Alert alert) {
        return alert.getText();
    }

    /**
     * Accept the alert
     *
     * @param alert object
     */
    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    /**
     * Dismiss the lert
     *
     * @param alert object
     */
    public void dismissAlert(Alert alert) {
        alert.dismiss();
    }

    /**
     * send given value to the textbox in Alert popup
     *
     * @param value
     * @param alert object
     */
    public void sendKeys(Alert alert, String value) {
        alert.sendKeys(value);
    }

    /**
     * Check if alert is present
     *
     * @return true if alert is present/ false if not
     */
    public boolean checkAlertIsPresent() {
        try {
            switchToAlert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }
}
