package com.QADemo.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxElement {
    private static final Logger logger = Logger.getLogger(CheckboxElement.class);
    private WebElementInteractions webElementInteractions;
    private WebElementLocator webElementLocator;

    public CheckboxElement(RemoteWebDriver driver, WebDriverWait wait) {
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementLocator = new WebElementLocator(driver);
    }

    /**
     * Mark Checkbox as checked.
     *
     * @param element webelement
     */
    public void selectCheckBox(WebElement element) {
        logger.info("        Selected checkbox: " + webElementInteractions.getTextFromWebElement(element));
        webElementInteractions.clickOnElement(element);
    }

    /**
     * this method return true/ false if element checked or not
     *
     * @param element
     * @return true if selected/ false if not
     */
    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Check if the checkbox is selected
     *
     * @param element checkbox element
     * @return true if checkbox is checked
     */
    public boolean isChecked(WebElement element) {
        boolean flag = false;
        String checkedValue = webElementInteractions.getAttributeFromWebElement(element, "checked");
        if (checkedValue.equals("checked") || (checkedValue.equals("true"))) {
            logger.info("        Checkbox Checked for Webelement: " + element);
            flag = true;
        } else {
            logger.error("        Checkbox Unchecked for Webelement: " + element);
        }
        return flag;
    }

    /**
     * check if the check box has been selected and return true
     *
     * @param element web element
     * @return true if the checkbox is selected
     */
    public boolean isCheckboxSelected(WebElement element) {
        boolean flag = false;
        if (isSelected(element)) {
            flag = true;
        }
        return flag;
    }
}
