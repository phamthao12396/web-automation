package com.adm;

import Utils.SeleniumBaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pageObjects.RegisterPageObject;

import java.util.logging.Logger;

public class RegisterTestcases extends SeleniumBaseTest {
    RegisterPageObject registerPageObject;



    @BeforeTest()
    public void beforeTest() {
        registerPageObject = new RegisterPageObject(driver);
    }

    @Test
    @Parameters({"countryName"})
    public void fillFormWithInvalidEmail(String countryName) {
        logger.info("Step 1: select DropDown Country, " + countryName);
        registerPageObject.selectCountry(countryName);
    }

    @Test
    @Parameters({"countryName"})
    public void fillFormWithValidEmail(String countryName) {

    }

    @AfterTest
    public void afterTest() {
    }
}
