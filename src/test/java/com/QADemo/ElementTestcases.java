package com.QADemo;

import Utils.SeleniumBaseTest;
import com.QADemo.commons.MenuNavigation;
import com.QADemo.commons.PageGeneratorManager;
import com.QADemo.pageObjects.CheckBoxPageObjects;
import org.testng.annotations.*;
import com.QADemo.pageObjects.TextBoxPageObjects;

public class ElementTestcases  extends SeleniumBaseTest {
    TextBoxPageObjects elementPageObject;
    MenuNavigation navigation;
    CheckBoxPageObjects checkBoxPageObjects;
    public static final String TEXTBOX_TAB = "Text Box";
    public static final String CHECKBOX_TAB = "Check Box";


    @BeforeMethod
    public void prepareMethod() {
        elementPageObject = new TextBoxPageObjects(driver, wait);
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
    @Parameters({"checkboxName"})
    public void checkbox(String checkboxName) {
        logger.info("Step 1.1: click To "+CHECKBOX_TAB);
        elementPageObject.clickToMenuByName(CHECKBOX_TAB);
        checkBoxPageObjects = PageGeneratorManager.getCheckBoxPageObjects(driver, wait);

        logger.info("Step 1.2: verify CheckBox title display");
        elementPageObject.verifyPageTitleDisplayed(CHECKBOX_TAB);

        logger.info("Step 2: Click to expanse icon");
        checkBoxPageObjects.clickToExpenseIcon();

        logger.info("Step 3: click to single checkbox by text: ");
        checkBoxPageObjects.checkToSingleCheckbox(checkboxName);

        logger.info("Step 4: Verify data displayed match with checkbox checked");
        checkBoxPageObjects.verifyDataDisplayedMatchWithCheckBoxName(checkboxName);
    }

    @AfterTest
    public void afterTest() {
    }
}
