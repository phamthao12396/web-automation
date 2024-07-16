package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(){};
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    //Web driver
    public void openUrl(String url) {
        driver.get(url);
    }

    public WebElement findElementById(String id){
        return driver.findElement(new By.ById(id));
    }

    public WebElement findElementByXpath(String xpath){
        return driver.findElement(new By.ByXPath(xpath));
    }

    public List<WebElement> findElements(String xpath){
        return driver.findElements(By.xpath(xpath));
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public void waitUntilElementVisibility(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitUntilElementPresentById(String id){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public void waitUntilElementPresentByXpath(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    //Web Element
    public void clickToElement(String xpath){
        findElementByXpath(xpath).click();
    }

    public void clearElement(String xpath){
        findElementByXpath(xpath).clear();
    }

    public String getAttribute(String xpath, String name){
        return findElementByXpath(xpath).getAttribute(name);
    }

    public String getTextByXpath(String xpath){
        return findElementByXpath(xpath).getText();
    }

    public void selectDropdownByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectDropdownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectDropdownByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

/*    public void selectCustomDropDown(String xpath, String selection){
        WebElement element = findElementByXpath(xpath);
        waitUntilElementPresentByXpath(xpath);
        element.click();
    }*/
}
