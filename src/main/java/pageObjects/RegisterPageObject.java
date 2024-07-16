package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.RegisterPageUIs;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver){
        super(driver);
    }

    public void selectCountry(String countryName){
        waitUntilElementPresentByXpath(RegisterPageUIs.countryDrop);
        findElementByXpath(RegisterPageUIs.countryDrop).click();
        waitUntilElementPresentByXpath(RegisterPageUIs.countryName);
        findElementByXpath(RegisterPageUIs.countryName).click();
    }

}
