package com.QADemo;

import Utils.SeleniumBaseTest;
import com.QADemo.commons.MenuNavigation;
import com.QADemo.commons.PageGeneratorManager;
import com.QADemo.pageObjects.CheckBoxPageObjects;
import com.QADemo.pageObjects.RadioPageObjects;
import com.QADemo.pageObjects.WebTablesPageObjects;
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
        textBoxPageObject.clickToTabByTabName("TextBox");

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
    @Parameters("checkboxName")
    public void clickToCheckBox(String checkboxName) {
        logger.info("Step 1.1: click To Check Box tab");
        CheckBoxPageObjects checkBoxPageObjects =  textBoxPageObject.clickToCheckBoxTab();

        logger.info("Step 1.2: verify CheckBox title display");
        checkBoxPageObjects.verifyPageTitleDisplayed();

        logger.info("Step 2: Click to Home expand icon");
        checkBoxPageObjects.clickToExpenseIcon();

        logger.info("Step 3: Verify Checkbox Private display");
        checkBoxPageObjects.verifyCheckBoxDisplayed(checkboxName);

        logger.info("Step 4: click to single checkbox");
        checkBoxPageObjects.checkToSingleCheckbox(checkboxName);

        logger.info("Step 5: Verify data displayed match with checkbox checked");
        checkBoxPageObjects.verifyDataDisplayedMatchWithCheckBoxName(checkboxName);
    }

    @Test
    @Parameters("radioName")
    public void radioButton(String radioName) {
        logger.info("Step 1.1: click To Radio Button tab");
        textBoxPageObject.clickToTabByTabName("Radio Button");
        RadioPageObjects radioPageObjects = PageGeneratorManager.getRadioButtonPageObjects(driver, wait);

        logger.info("Step 2: Click to "+radioName+" button");
        radioPageObjects.clickToRadioButtonByName(radioName);

        logger.info("Step 3: Verify the text result displayed match with the Radio selected");
        radioPageObjects.verifyTheTextDisplayedMatchWithRadioButtonSelected(radioName);
    }

    @Test(dataProvider = "addNewRecord", dataProviderClass = WebTablesPageObjects.class)
    public void addNewRecordToTable(String firstName, String lastName, String email, String age, String salary, String department) {
        logger.info("Step 1: click To Web Table tab");
        textBoxPageObject.clickToTabByTabName("Web Tables");
        WebTablesPageObjects webTablesPageObjects = PageGeneratorManager.getWebTablesPageObjects(driver, wait);

        logger.info("Step 2: Click to Add button");
        webTablesPageObjects.clickToAddBtn();

        logger.info("Step 3: Verify the Registration Form displayed");
        webTablesPageObjects.verifyRegistrationFormDisplayed();

        logger.info("Step 4: Enter data to all field");
        webTablesPageObjects.enterDataToRegistrationForm(firstName, lastName, email, age, salary, department);

        logger.info("Step 5: Click to Submit button");
        webTablesPageObjects.clickSubmitBtn();

        logger.info("Step 6: Verify new record is present in the table");
        webTablesPageObjects.verifyNewRecordIsPresentInTheTable();

        logger.info("Step 7: Verify record details match input");
        webTablesPageObjects.verifyRecordDetailsMatchWithInputData();
    }

    @Test
    @Parameters("radioName")
    public void editRecord(String radioName){

    }

    @Test
    @Parameters("radioName")
    public void deleteRecord(String radioName){

    }

    @AfterTest
    public void afterTest() {
    }
}
