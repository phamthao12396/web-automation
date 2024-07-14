package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;


    //Web driver
    public void openUrl(String url){
        driver.get(url);
    }



    //Web Elements
    public WebElement findElementByXpath(String xpath){
        WebElement element =  driver.findElement(By.xpath(xpath));
        return element;
    }
    public void clickToElement(String xpath){
        WebElement element=  waitElementVisibility(xpath);
        element.click();
    }

    public WebElement waitElementVisibility(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;

    }
}
