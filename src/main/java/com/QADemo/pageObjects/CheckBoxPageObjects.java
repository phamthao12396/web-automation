package com.QADemo.pageObjects;

import com.Selenium.CheckboxElement;
import com.Selenium.WebDriverInteractions;
import com.Selenium.WebElementInteractions;
import com.Selenium.WebElementWaits;
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
    private WebElementInteractions  webElementInteractions;
    private TextBoxPageUIs textBoxPageUIs;
    private CheckBoxPageUIs checkBoxPageUIs;
    private CheckboxElement checkboxElement;
    private WebElementWaits webElementWaits;
    private WebDriverInteractions webDriverInteractions;
    public CheckBoxPageObjects(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        textBoxPageUIs = new TextBoxPageUIs(driver, wait);
        checkBoxPageUIs = new CheckBoxPageUIs(driver, wait);
        webElementInteractions = new WebElementInteractions(driver, wait);
        checkboxElement = new CheckboxElement(driver, wait);
        webElementWaits = new WebElementWaits(wait);
        webDriverInteractions = new WebDriverInteractions(driver);
    }

    public void clickToExpenseIcon() {
        webElementInteractions.clickOnElement(checkBoxPageUIs.expandButton());
    }

    public void checkToSingleCheckbox(String checkboxName) {
        webDriverInteractions.scrollToElement(checkBoxPageUIs.checkBoxByName(checkboxName));
        checkboxElement.selectCheckBox(checkBoxPageUIs.checkBoxByName(checkboxName));
        try {
            Thread.sleep(5000); // Đợi 5 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyDataDisplayedMatchWithCheckBoxName(String checkboxName) {
        Assert.assertTrue(checkBoxPageUIs.selectedResult().equalsIgnoreCase(checkboxName), "Strings are not equal ignoring case");
    }

    public void verifyPageTitleDisplayed() {
        Boolean flag = webElementInteractions.isDisplayed(textBoxPageUIs.titleByName(CHECKBOX_TAB));
        if (flag) {
            logger.info("Element displayed.");
        }
    }

    public void verifyCheckBoxDisplayed(String checkboxName) {
        Boolean flag = webElementInteractions.isDisplayed(checkBoxPageUIs.checkBoxByName(checkboxName));
        if (flag) {
            logger.info("Element displayed.");
        }
    }
}
