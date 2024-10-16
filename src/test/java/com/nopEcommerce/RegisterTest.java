package com.nopEcommerce;

import Utils.SeleniumBaseTest;
import com.nopEcommerce.Commons.PageGeneratorManager;
import com.nopEcommerce.pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends SeleniumBaseTest {
    private RegisterPageObject registerPageObject;
    @BeforeMethod
    public void beforeMethod(){
        registerPageObject = PageGeneratorManager.getRegisterPageObject(driver, wait);
    }

    @Test
    public void registerWithEmptyData(){
        logger.info("Step 1: Click to Register link");
        logger.info("Step 1.1: Verify Register page displayed");
        logger.info("Step 2: Click to Register button");
        logger.info("Step 2.1: Verify error messages displayed");
    }
}
