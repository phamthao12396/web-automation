package com.QADemo.pageObjects;

import com.QADemo.Selenium.CheckboxElement;
import com.QADemo.Selenium.WebElementInteractions;
import com.QADemo.Selenium.WebElementWaits;
import com.QADemo.pageUIs.CheckBoxPageUIs;
import com.QADemo.pageUIs.TextBoxPageUIs;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CheckBoxPageObjects {
    private static final Logger logger = Logger.getLogger(CheckBoxPageObjects.class);
    public static final String CHECKBOX_TAB = "Check Box";
    RemoteWebDriver driver;
    WebElementInteractions  webElementInteractions;
    TextBoxPageUIs textBoxPageUIs;
    CheckBoxPageUIs checkBoxPageUIs;
    CheckboxElement checkboxElement;
    public CheckBoxPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        webElementInteractions = new WebElementInteractions(driver, wait);
        checkboxElement = new CheckboxElement(driver, wait);
    }

    public void clickToExpenseIcon() {
        webElementInteractions.clickOnElement(checkBoxPageUIs.homeExpanseIcon());
    }
    public void clickToExpenseIconByText(String checkBoxText) {
        webElementInteractions.clickOnElement(checkBoxPageUIs.expandByCheckBoxText(checkBoxText));
    }

    public void checkToSingleCheckbox(String checkboxName) {
        checkboxElement.selectCheckBox(checkBoxPageUIs.checkBoxByName(checkboxName));
    }

    public void verifyDataDisplayedMatchWithCheckBoxName(String checkboxName) {
        Assert.assertEquals(checkBoxPageUIs.selectedResult(), checkboxName);
    }

    public void verifyPageTitleDisplayed() {
        Boolean flag = webElementInteractions.isDisplayed(textBoxPageUIs.titleByName(CHECKBOX_TAB));
        if (flag) {
            logger.info("Element displayed.");
        }
    }

    public void verifyCheckBoxIsSelected(String checkboxName) {
        Assert.assertTrue(checkboxElement.isSelected(checkBoxPageUIs.checkBoxByName(checkboxName)));
    }
}
