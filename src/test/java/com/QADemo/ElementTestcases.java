package com.QADemo;

import Utils.SeleniumBaseTest;
import com.QADemo.commons.MenuNavigation;
import com.QADemo.commons.PageGeneratorManager;
import com.QADemo.pageObjects.CheckBoxPageObjects;
import org.testng.annotations.*;
import com.QADemo.pageObjects.TextBoxPageObjects;

public class ElementTestcases  extends SeleniumBaseTest {
    TextBoxPageObjects textBoxPageObject;
    MenuNavigation navigation;

    @BeforeMethod
    public void prepareMethod() {
        navigation = new MenuNavigation(driver);
        textBoxPageObject = PageGeneratorManager.getTextBoxPageObjects(driver, wait);
        navigation.navigateToElement();
    }

    @Test
    @Parameters({"fullName", "email", "currentAddress", "permanentAddress"})
    public void textBox(String name, String email, String currentAddress, String permanentAddress) {
        logger.info("Step 1.1: click To TextBox tab");
        textBoxPageObject.clickToTextBoxTab();

        logger.info("Step 1.2: verify TextBox title display");
        textBoxPageObject.verifyPageTitleDisplayed();

        logger.info("Step 2: input value to textboxes");
        textBoxPageObject.sendKeysToForm(name, email, currentAddress, permanentAddress);

        logger.info("Step 2.2: click Submit button");
        textBoxPageObject.clickSubmitButton();

        logger.info("Step 3: Verify data displayed match with data input");
        textBoxPageObject.verifyDataDisplayedMatchWithGivenData(name, email, currentAddress, permanentAddress);
    }

    @Test
    public void clickToCheckBox() {
        logger.info("Step 1.1: click To Check Box tab");
        CheckBoxPageObjects checkBoxPageObjects =  textBoxPageObject.clickToCheckBoxTab();

        logger.info("Step 1.2: verify CheckBox title display");
        checkBoxPageObjects.verifyPageTitleDisplayed();

        logger.info("Step 2: Click to Home expand icon");
        checkBoxPageObjects.clickToExpenseIcon();

        logger.info("Step 3: Click to Documents expand icon");
        checkBoxPageObjects.clickToExpenseIcon();

        logger.info("Step 4: Click to Office expand icon");
        checkBoxPageObjects.clickToExpenseIcon();

        logger.info("Step 5: click to single checkbox");
        checkBoxPageObjects.checkToSingleCheckbox("Private");

        logger.info("Step 6: Verify checkbox is selected");
        checkBoxPageObjects.verifyCheckBoxIsSelected("Private");

        logger.info("Step 7: Verify data displayed match with checkbox checked");
        checkBoxPageObjects.verifyDataDisplayedMatchWithCheckBoxName("Private");
    }

    @AfterTest
    public void afterTest() {
    }
}
