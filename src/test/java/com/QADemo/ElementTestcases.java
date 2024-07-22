package com.QADemo;

import Utils.SeleniumBaseTest;
import com.QADemo.commons.MenuNavigation;
import org.testng.annotations.*;
import com.QADemo.pageObjects.ElementPageObject;

public class ElementTestcases  extends SeleniumBaseTest {
    ElementPageObject elementPageObject;
    MenuNavigation navigation;
    public static final String TEXTBOX_TAB = "Text Box";
    public static final String CHECKBOX_TAB = "Check Box";


    @BeforeMethod
    public void prepareMethod() {
        elementPageObject = new ElementPageObject(driver, wait);
        navigation = new MenuNavigation(driver);
        navigation.navigateToElement();
    }

    @Test
    @Parameters({"fullName", "email", "currentAddress", "permanentAddress"})
    public void textBox(String name, String email, String currentAddress, String permanentAddress) {
        logger.info("Step 1.1: click To "+TEXTBOX_TAB);
        elementPageObject.clickToMenuByName(TEXTBOX_TAB);

        logger.info("Step 1.2: verify TextBox title display");
        elementPageObject.verifyPageTitleDisplayed(TEXTBOX_TAB);

        logger.info("Step 2: input value to textboxes");
        elementPageObject.sendKeysToForm(name, email, currentAddress, permanentAddress);

        logger.info("Step 2.2: click Submit button");
        elementPageObject.clickSubmitButton();

        logger.info("Step 3: Verify data displayed match with data input");
        elementPageObject.verifyDataDisplayedMatchWithGivenData(name, email, currentAddress, permanentAddress);
    }

    @Test
    public void checkbox() {
        logger.info("Step 1.1: click To "+CHECKBOX_TAB);
        elementPageObject.clickToMenuByName(CHECKBOX_TAB);

        logger.info("Step 1.2: verify CheckBox title display");
        elementPageObject.verifyPageTitleDisplayed(CHECKBOX_TAB);

        logger.info("Step 2: Click to expanse icon");
        elementPageObject.sendKeysToForm(name, email, currentAddress, permanentAddress);

        logger.info("Step 3: click to single checkbox");
        elementPageObject.clickSubmitButton();

        logger.info("Step 4: Verify data displayed match with checkbox checked");
        elementPageObject.verifyDataDisplayedMatchWithGivenData(name, email, currentAddress, permanentAddress);
    }

    @AfterTest
    public void afterTest() {
    }
}
