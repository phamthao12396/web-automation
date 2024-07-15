package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {
    WebDriver driver;
    protected final Logger logger;
    protected BaseTest(){
        logger = LoggerFactory.getLogger(getClass());
    }

    public WebDriver getBrowserDriver(String browserDriver, String url){
        switch (browserDriver){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.get(url);
        return driver;
    }
}
