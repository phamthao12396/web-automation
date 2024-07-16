package com.adm;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.RegisterPageObject;

public class RegisterTestcases extends BaseTest {
    WebDriver driver;
    RegisterPageObject registerPageObject;

    @Parameters({"browser", "url"})
    @BeforeTest()
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        registerPageObject = PageGeneratorManager.getRegisterPageObject(driver);
    }

    @Test
    @Parameters({"countryName"})
    public void fillFormWithInvalidEmail(String countryName) {
        logger.info("Step 1: select DropDown Country, {}", countryName);
        registerPageObject.selectCountry(countryName);
    }

    @Test
    @Parameters({"countryName"})
    public void fillFormWithValidEmail(String countryName) {

    }

    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}
