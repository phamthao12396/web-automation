package com.QADemo.pageObjects;

import com.QADemo.Selenium.TextInputElement;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.pageUIs.WebTablesPageUIs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPageObjects {
    private final String POPUP_TITLE = "Registration Form";
    private WebTablesPageUIs webTablesPageUIs;
    private WebElementInteractions webElementInteractions;
    private TextInputElement textInputElement;
    public WebTablesPageObjects(){

    }

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

    public void verifyNewRecordIsPresentInTheTable(String email) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(webTablesPageUIs.emailTxt(), email, "Email should match.");
    }

    public List<String> getAllDataOfRacordAdded(){
        ArrayList<String> addedRecord = new ArrayList<>();
        addedRecord.add(webTablesPageUIs.fisrtNameTxt());
        addedRecord.add(webTablesPageUIs.lastNameTxt());
        addedRecord.add(webTablesPageUIs.emailTxt());
        addedRecord.add(webTablesPageUIs.ageTxt());
        addedRecord.add(webTablesPageUIs.salaryTxt());
        addedRecord.add(webTablesPageUIs.departmentTxt());
        return  addedRecord;
    }

    public void verifyRecordDetailsMatchWithInputData(String firstName, String lastName, String email, String age, String salary, String department) {
        List<String> addedRecord = getAllDataOfRacordAdded();
        Assert.assertEquals(addedRecord.get(0), firstName, "FirstName should be match");
        Assert.assertEquals(addedRecord.get(1), lastName, "Last name should be match");
        Assert.assertEquals(addedRecord.get(2), email, "Email should be match");
        Assert.assertEquals(addedRecord.get(3), age, "Age should be match");
        Assert.assertEquals(addedRecord.get(4), salary, "Salary should be match");
        Assert.assertEquals(addedRecord.get(5), department, "Department should be match");
    }

    public void seachRecordByText(String email) {
        webElementInteractions.clickOnElement(webTablesPageUIs.searchTBx());
        textInputElement.sendKeysWithTab(webTablesPageUIs.searchTBx(), email);
    }
}
