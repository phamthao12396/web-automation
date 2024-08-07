package com.QADemo.pageObjects;

import com.QADemo.Selenium.TextInputElement;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.pageUIs.WebTablesPageUIs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class WebTablesPageObjects {
    private final String POPUP_TITLE = "Registration Form";
    private WebTablesPageUIs webTablesPageUIs;
    private WebElementInteractions webElementInteractions;
    private TextInputElement textInputElement;
    public WebTablesPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        webTablesPageUIs = new WebTablesPageUIs(driver, wait);
        webElementInteractions = new WebElementInteractions(driver, wait);
        textInputElement = new TextInputElement(driver, wait);
    }
    @DataProvider(name = "addNewRecord")
    public Object[][] addNewRecord1(){
        return new Object[][]{
                {"Thao","Thi","thao@mail.vn","23","123456","AB"}
        };
    }

    public void clickToAddBtn() {
        webElementInteractions.clickOnElement(webTablesPageUIs.addBtn());
    }

    public void verifyRegistrationFormDisplayed() {
        Assert.assertEquals(webTablesPageUIs.registrationFormTitle(), POPUP_TITLE, "Registration Form should displayed.");
    }

    public void enterDataToRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department) {
        textInputElement.sendKeysWithTab(webTablesPageUIs.firstNameTBx(), firstName);
        textInputElement.sendKeysWithTab(webTablesPageUIs.lastNameTbx(), lastName);
        textInputElement.sendKeysWithTab(webTablesPageUIs.emailTBx(), email);
        textInputElement.sendKeysWithTab(webTablesPageUIs.ageTBx(), age);
        textInputElement.sendKeysWithTab(webTablesPageUIs.salaryTBx(), salary);
        textInputElement.sendKeysWithTab(webTablesPageUIs.departmentTBx(), department);
    }

    public void clickSubmitBtn() {
        webElementInteractions.clickOnElement(webTablesPageUIs.submitBtn());
    }

    public void verifyNewRecordIsPresentInTheTable() {

    }

    public void verifyRecordDetailsMatchWithInputData() {

    }
}
