package Utils;

import Selenium.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class SeleniumBaseTest extends CommonBaseTest{
    protected RemoteWebDriver driver;
    private Actions actions;
    protected AlertElement alertElement;
    protected CheckboxElement checkboxElement;
    protected FrameWebElement frameWebElement;
    protected PerformActions performActions;
    protected SelectDropDown selectDropDown;
    protected SwitchToPopUp switchToPopUp;
    protected TableWebElement tableWebElement;
    protected TextInputElement textInputElement;
    protected WebDriverInteractions webDriverInteractions;
    protected WebElementInteractions webElementInteractions;
    protected WebElementLocator webElementLocator;
    protected WebElementWaits webElementWaits;

    public SeleniumBaseTest(){

    }
    public SeleniumBaseTest(RemoteWebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(this.getClass().getName() + "],[" + driver);
    }

    @BeforeMethod
    @Parameters({"browser", "url"})
    public RemoteWebDriver getBrowserDriver(String browserDriver, String url){
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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
