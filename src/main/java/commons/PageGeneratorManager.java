package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.RegisterPageObject;

public class PageGeneratorManager {
    public static RegisterPageObject getRegisterPageObject(WebDriver driver){
        return new RegisterPageObject(driver);
    }
}
