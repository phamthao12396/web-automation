package Utils;

import com.QADemo.Selenium.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;


public class SeleniumBaseTest extends CommonBaseTest{
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    public static final int MAX_CONNECTION_ATTEMPTS = 5;

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
    @Parameters({"browser", "url", "timeout"})
    public void setUp(String browserDriver, String url, int timeout) throws InterruptedException, MalformedURLException {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        driver.manage().window().maximize();

        alertElement = new AlertElement(driver);
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementWaits = new WebElementWaits(wait);
        checkboxElement = new CheckboxElement(driver, wait);
        frameWebElement = new FrameWebElement(driver, wait);
        performActions = new PerformActions(driver);
        selectDropDown = new SelectDropDown(driver, wait);
        switchToPopUp = new SwitchToPopUp(driver);
        tableWebElement = new TableWebElement(driver, wait);
        textInputElement = new TextInputElement(driver, wait);
        webDriverInteractions = new WebDriverInteractions(driver);
        webElementLocator = new WebElementLocator(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
