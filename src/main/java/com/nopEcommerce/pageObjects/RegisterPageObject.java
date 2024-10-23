package com.nopEcommerce.pageObjects;

import com.Selenium.TextInputElement;
import com.Selenium.WebElementInteractions;
import com.nopEcommerce.pageUIs.RegisterPageUIs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class RegisterPageObject {
    private RegisterPageUIs registerPageUIs;
    private WebElementInteractions webElementInteractions;
    private TextInputElement textInputElement;

    public RegisterPageObject(){}

    public RegisterPageObject(RemoteWebDriver driver, WebDriverWait wait){
        registerPageUIs = new RegisterPageUIs(driver, wait);
        webElementInteractions = new WebElementInteractions(driver, wait);
        textInputElement= new TextInputElement(driver, wait);
    }

    @DataProvider(name = "RegisterWithAnInvalidEmail")
    public Object[][] invalidEmail(){
        return new Object[][]{
                {"Thi", "Pham", "email", "123", "123"}
        };
    }

    @DataProvider(name = "RegisterWithValidData")
    public Object[][] validData(){
        return new Object[][]{
                {"Thi", "Pham", "test@gmail.vn", "123456", "123456"}
        };
    }

    @DataProvider(name = "RegisterWithPasswordLessThan6")
    public Object[][] passwordLessThan6(){
        return new Object[][]{
                {"Thi", "Pham", "test@gmail.vn", "123", "123"}
        };
    }

    public void verifyRegisterPageDisplayed() {
        Assert.assertEquals(registerPageUIs.registerText(), "Register");
    }

    public void clickToRegisterButton() {
        webElementInteractions.scrollToElement(registerPageUIs.registerButton());
        webElementInteractions.clickOnElement(registerPageUIs.registerButton());
    }

    public void verifyErrorMessagesDisplayed() {
        Assert.assertEquals(registerPageUIs.firstNameError(), "First name is required.", "Error message should match.");
        Assert.assertEquals(registerPageUIs.lastNameError(), "Last name is required.", "Error message should match.");
        Assert.assertEquals(registerPageUIs.emailError(), "Email is required.","Error message should match.");
        Assert.assertEquals(registerPageUIs.passwordError(), "Password is required.","Error message should match.");
    }

    public void inputDataToRegisterForm(String firstName, String lastname, String email, String pass, String confirmPass) {
        textInputElement.sendKeysWithTab(registerPageUIs.firstNameTxt(), firstName);
        textInputElement.sendKeysWithTab(registerPageUIs.lastNameTxt(), lastname);
        textInputElement.sendKeysWithTab(registerPageUIs.emailTxt(), email);
        textInputElement.sendKeysWithTab(registerPageUIs.passwordTxt(), pass);
        textInputElement.sendKeysWithTab(registerPageUIs.confirmPasswordTxt(), confirmPass);
    }

    public void verifyInvalidEmailMessageDisplay() {
        Assert.assertEquals(registerPageUIs.emailError(), "Please enter a valid email address.", "Error message should match.");
    }

    public void verifySuccessMessageDisplay() {
        Assert.assertEquals(registerPageUIs.successRegisterMessage(), "Your registration completed", "Success message should match.");
    }

    public void verifyEmailExistsMessageDisplay() {
        Assert.assertEquals(registerPageUIs.validationError(), "The specified email already exists", "Error message should match.");
    }

    public void verifyPasswordLessThan6ErrorMessageDisplay() {
    }
}
