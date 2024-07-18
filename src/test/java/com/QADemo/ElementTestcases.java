package com.QADemo;

import Utils.SeleniumBaseTest;
import com.QADemo.commons.MenuNavigation;
import org.testng.annotations.*;
import com.QADemo.pageObjects.ElementPageObject;

public class ElementTestcases  extends SeleniumBaseTest {
    ElementPageObject elementPageObject;
    MenuNavigation navigation;


    @BeforeMethod
    public void prepareMethod() {
        navigation = new MenuNavigation(driver);
        navigation.navigateToElement();
    }

    @Test
    @Parameters({"tabName", "fullName", "email", "currentAddress", "permanentAddress"})
    public void textBox(String tabName, String name, String email, String currentAddress, String permanentAddress) {
        logger.info("Step 1.1: click To 'TextBox'");
        elementPageObject.clickToMenuByName(tabName);

        logger.info("Step 1.2: verify TextBox title display");
        elementPageObject.verifyPageTitleDisplayed(tabName);

        logger.info("Step 2: input value to textboxes");
        elementPageObject.sendKeysToForm(name, email, currentAddress, permanentAddress);

        logger.info("Step 2.2: click Submit button");
        elementPageObject.clickSubmitButton();

        logger.info("Step 3: Verify data displayed match with data input");
        
    }

    @Test
    public void checkbox() {

    }

    @AfterTest
    public void afterTest() {
    }
}
