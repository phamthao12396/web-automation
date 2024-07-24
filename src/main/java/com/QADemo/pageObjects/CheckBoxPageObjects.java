package com.QADemo.pageObjects;

import com.QADemo.Selenium.WebElementWaits;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPageObjects {
    RemoteWebDriver driver;
    WebElementWaits webElementWaits;
    public CheckBoxPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        webElementWaits = new WebElementWaits(wait);
    }

    public void clickToExpenseIcon() {
    }

    public void checkToSingleCheckbox(String checkboxName) {
    }

    public void verifyDataDisplayedMatchWithCheckBoxName(String checkboxName) {
    }
}
