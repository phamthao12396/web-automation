package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUIs;

public class RegisterPageObject extends BasePage {
    WebDriver driver;
    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
    }


}
