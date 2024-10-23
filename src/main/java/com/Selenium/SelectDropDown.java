package com.Selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown {
    private static final Logger logger = Logger.getLogger(SelectDropDown.class);
    private WebElementInteractions webElementInteractions;
    private WebElementLocator webElementLocator;
    private TextInputElement textInputElement;
    private PerformActions performActions;

    public SelectDropDown(RemoteWebDriver driver, WebDriverWait wait) {
        webElementInteractions = new WebElementInteractions(driver, wait);
        webElementLocator = new WebElementLocator(driver);
        textInputElement = new TextInputElement(driver, wait);
        performActions = new PerformActions(driver);
    }

    /**
     * select a dropdown web element and return select object
     *
     * @param element the dropdown web element needs to be selected
     * @return Select object
     */
    public Select selectDropdownByElement(WebElement element) {
        return new Select(element);
    }

    /**
     * select given dropdown element and return the first selected option
     *
     * @param element the web element needs to be selected
     * @return WebElement the first selected option in dropdown
     */
    public WebElement getFirstSelectedOptionByWebElement(WebElement element) {
        Select select = selectDropdownByElement(element);
        return select.getFirstSelectedOption();
    }

    /**
     * Select an option from dropdown by visible text
     *
     * @param element     dropdown element
     * @param visibleText visible text
     */
    public void selectDropdownOptionByVisibleText(WebElement element, String visibleText) {
        selectDropdownByElement(element).selectByVisibleText(visibleText);

    }

    /**
     * Select an option from dropdown by value
     *
     * @param element dropdown element
     * @param value   value text
     */
    public void selectDropdownOptionByValue(WebElement element, String value) {
        selectDropdownByElement(element).selectByValue(value);

    }

    /**
     * Select an option from dropdown by index
     *
     * @param element dropdown element
     * @param index   index value
     */
    public void selectDropdownOptionByIndex(WebElement element, int index){
        selectDropdownByElement(element).selectByIndex(index);
    }

    /**
     * method to locate the input text item n select2-drop dropdown
     *
     * @return web element
     */
    public WebElement select2DropInput(String xpath) {
        return webElementLocator.findElementByXpath(xpath);
    }

    /**
     * click on the given dropdown element , locate input text, send given value and press tab
     *
     * @param element dropdown
     * @param value   text
     * @param inputTextBox textbox
     */
    public void selectFromDropdownWithValue(WebElement element, WebElement inputTextBox, String value){
        webElementInteractions.clickOnElement(element);
        textInputElement.sendKeysWithTab(inputTextBox,value);
    }
}
