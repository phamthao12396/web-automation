package com.nopEcommerce;

import com.Utils.SeleniumBaseTest;
import com.nopEcommerce.Commons.Navigation;
import com.nopEcommerce.pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends SeleniumBaseTest {
    private Navigation navigation;

    @BeforeMethod
    public void beforeMethod(){
        navigation = new Navigation(driver, wait);
    }

    @Test
    public void registerWithEmptyData(){
        logger.info("Step 1: Click to Register link");
        RegisterPageObject registerPageObject = navigation.navigateToRegisterPage(driver, wait);

        logger.info("Step 1.1: Verify Register page displayed");
        registerPageObject.verifyRegisterPageDisplayed();

        logger.info("Step 2: Click to Register button");
        registerPageObject.clickToRegisterButton();

        logger.info("Step 2.1: Verify error messages displayed");
        registerPageObject.verifyErrorMessagesDisplayed();
    }

    @Test(dataProvider = "RegisterWithAnInvalidEmail", dataProviderClass = RegisterPageObject.class)
    public void registerWithInvalidEmail(String firstName, String lastname, String email, String pass, String confirmPass){
        logger.info("Step 1: Click to Register link");
        RegisterPageObject registerPageObject = navigation.navigateToRegisterPage(driver, wait);

        logger.info("Step 1.1: Verify Register page displayed");
        registerPageObject.verifyRegisterPageDisplayed();

        logger.info("Input invalid email");
        registerPageObject.inputDataToRegisterForm(firstName, lastname, email, pass, confirmPass);

        logger.info("Step 2: Click to Register button");
        registerPageObject.clickToRegisterButton();

        logger.info("Step 2.1: Verify error messages displayed");
        registerPageObject.verifyInvalidEmailMessageDisplay();
    }

    @Test(dataProvider = "RegisterWithValidData", dataProviderClass = RegisterPageObject.class)
    public void registerWithValidData(String firstName, String lastname, String email, String pass, String confirmPass){
        logger.info("Step 1: Click to Register link");
        RegisterPageObject registerPageObject = navigation.navigateToRegisterPage(driver, wait);

        logger.info("Step 1.1: Verify Register page displayed");
        registerPageObject.verifyRegisterPageDisplayed();

        logger.info("Input valid data to register");
        registerPageObject.inputDataToRegisterForm(firstName, lastname, email, pass, confirmPass);

        logger.info("Step 2: Click to Register button");
        registerPageObject.clickToRegisterButton();

        logger.info("Step 2.1: Verify success messages displayed");
        registerPageObject.verifySuccessMessageDisplay();
    }

    @Test(dataProvider = "RegisterWithValidData", dataProviderClass = RegisterPageObject.class)
    public void registerWithEmailAlreadyExists(String firstName, String lastname, String email, String pass, String confirmPass){
        logger.info("Step 1: Click to Register link");
        RegisterPageObject registerPageObject = navigation.navigateToRegisterPage(driver, wait);

        logger.info("Step 1.1: Verify Register page displayed");
        registerPageObject.verifyRegisterPageDisplayed();

        logger.info("Input valid data to register");
        registerPageObject.inputDataToRegisterForm(firstName, lastname, email, pass, confirmPass);

        logger.info("Step 2: Click to Register button");
        registerPageObject.clickToRegisterButton();

        logger.info("Step 2.1: Verify error messages displayed");
        registerPageObject.verifyEmailExistsMessageDisplay();
    }

    @Test(dataProvider = "RegisterWithPasswordLessThan6", dataProviderClass = RegisterPageObject.class)
    public void registerWithPassWordLessThan6Characters(String firstName, String lastname, String email, String pass, String confirmPass){
        logger.info("Step 1: Click to Register link");
        RegisterPageObject registerPageObject = navigation.navigateToRegisterPage(driver, wait);

        logger.info("Step 1.1: Verify Register page displayed");
        registerPageObject.verifyRegisterPageDisplayed();

        logger.info("Input valid data to register");
        registerPageObject.inputDataToRegisterForm(firstName, lastname, email, pass, confirmPass);

        logger.info("Step 2: Click to Register button");
        registerPageObject.clickToRegisterButton();

        logger.info("Step 2.1: Verify error messages displayed");
        registerPageObject.verifyPasswordLessThan6ErrorMessageDisplay();
    }
}
