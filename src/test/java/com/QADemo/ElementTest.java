package com.QADemo;

import Utils.SeleniumBaseTest;
import com.QADemo.commons.MenuNavigation;
import com.QADemo.commons.PageGeneratorManager;
import com.QADemo.pageObjects.CheckBoxPageObjects;
import com.QADemo.pageObjects.RadioPageObjects;
import com.QADemo.pageObjects.WebTablesPageObjects;
import org.testng.annotations.*;
import com.QADemo.pageObjects.TextBoxPageObjects;

public class ElementTest  extends SeleniumBaseTest {
    TextBoxPageObjects textBoxPageObject;
    MenuNavigation navigation;
    private WebTablesPageObjects webTablesPageObjects;

    @BeforeMethod
    public void prepareMethod() {
        navigation = new MenuNavigation(driver);
        textBoxPageObject = PageGeneratorManager.getTextBoxPageObjects(driver, wait);
        webTablesPageObjects = new WebTablesPageObjects(driver, wait);
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

        logger.info("Step 2: Click to Add button");
        webTablesPageObjects.clickToAddBtn();

        logger.info("Step 3: Verify the Registration Form displayed");
        webTablesPageObjects.verifyRegistrationFormDisplayed();

        logger.info("Step 4: Enter data to all field");
        webTablesPageObjects.enterDataToRegistrationForm(firstName, lastName, email, age, salary, department);

        logger.info("Step 5: Click to Submit button");
        webTablesPageObjects.clickSubmitBtn();

        logger.info("step 6: search record");
        webTablesPageObjects.seachRecordByText(email);

        logger.info("Step 7: Verify new record is present in the table");
        webTablesPageObjects.verifyNewRecordIsPresentInTheTable(email);

        logger.info("Step 8: Verify record details match input");
        webTablesPageObjects.verifyRecordDetailsMatchWithInputData(firstName, lastName, email, age, salary, department);
    }

    @Test(dataProvider = "editRecord", dataProviderClass = WebTablesPageObjects.class)
    public void editRecord(String firstName, String lastName, String email, String age, String salary, String department, String editName) {
        logger.info("Step 1: click To Web Table tab");
        textBoxPageObject.clickToTabByTabName("Web Tables");

        logger.info("Step 2: Click to Add button");
        webTablesPageObjects.clickToAddBtn();

        logger.info("Step 3: Verify the Registration Form displayed");
        webTablesPageObjects.verifyRegistrationFormDisplayed();

        logger.info("Step 4: Enter data to all field");
        webTablesPageObjects.enterDataToRegistrationForm(firstName, lastName, email, age, salary, department);

        logger.info("Step 5: Click to Submit button");
        webTablesPageObjects.clickSubmitBtn();

        logger.info("step 6: search record");
        webTablesPageObjects.seachRecordByText(email);

        logger.info("Step 7: Verify new record is present in the table");
        webTablesPageObjects.verifyNewRecordIsPresentInTheTable(email);

        logger.info("Step 8: Verify record details match input");
        webTablesPageObjects.verifyRecordDetailsMatchWithInputData(firstName, lastName, email, age, salary, department);

        logger.info("Step 9.1: click Edit button");
        webTablesPageObjects.clickToEditBtn();

        logger.info("Step 9.2: Edit data");
        webTablesPageObjects.editData(editName);

        logger.info("Step 10: Click to Submit button");
        webTablesPageObjects.clickSubmitBtn();

        logger.info("step 11: search record");
        webTablesPageObjects.seachRecordByText(email);

        logger.info("Step 12: Verify record is present in the table");
        webTablesPageObjects.verifyNewRecordIsPresentInTheTable(email);

        logger.info("Step 13: Verify record details match with edit data");
        webTablesPageObjects.verifyRecordDetailsMatchWithInputData(editName, lastName, email, age, salary, department);
    }


    @Test(dataProvider = "addNewRecord", dataProviderClass = WebTablesPageObjects.class)
    public void deleteRecord(String firstName, String lastName, String email, String age, String salary, String department){
        logger.info("Step 1: click To Web Table tab");
        textBoxPageObject.clickToTabByTabName("Web Tables");

        logger.info("Step 2: Click to Add button");
        webTablesPageObjects.clickToAddBtn();

        logger.info("Step 3: Verify the Registration Form displayed");
        webTablesPageObjects.verifyRegistrationFormDisplayed();

        logger.info("Step 4: Enter data to all field");
        webTablesPageObjects.enterDataToRegistrationForm(firstName, lastName, email, age, salary, department);

        logger.info("Step 5: Click to Submit button");
        webTablesPageObjects.clickSubmitBtn();

        logger.info("step 6: search record");
        webTablesPageObjects.seachRecordByText(email);

        logger.info("Step 7: Verify new record is present in the table");
        webTablesPageObjects.verifyNewRecordIsPresentInTheTable(email);

        logger.info("Step 8: Verify record details match input");
        webTablesPageObjects.verifyRecordDetailsMatchWithInputData(firstName, lastName, email, age, salary, department);

        logger.info("step 9: Delete record");
        webTablesPageObjects.deleteRecord(email);
    }

    @AfterTest
    public void afterTest() {
    }
}
