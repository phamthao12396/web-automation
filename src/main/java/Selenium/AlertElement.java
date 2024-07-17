package Selenium;


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.RemoteWebDriver;



public class AlertElement {
    private static final Logger logger = Logger.getLogger(AlertElement.class);
    private RemoteWebDriver driver;

    public AlertElement(RemoteWebDriver driver) {
        this.driver = driver;
    }

    /**
     * switch to alert message
     *
     * @return alert object
     */
    public Alert switchToAlert() {
        return driver.switchTo().alert();
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
}
