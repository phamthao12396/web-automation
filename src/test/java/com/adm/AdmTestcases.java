package com.adm;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdmTestcases extends BasePage {
WebDriver driver;
WebDriverWait explicitWait;

@BeforeClass
    public void beforeClass(){
    driver = new ChromeDriver();
    explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    driver.manage().window().maximize();
}
@Test
    public void fillAdmForm(){

    openUrl("https://development.d3m8y0cf0nidug.amplifyapp.com/auth/signup");

    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(countryDrop)));
    driver.findElement(By.xpath(countryDrop)).click();

    String countryName = "//p-dropdown[@optionlabel='countryName']//p-dropdownitem[1]";
    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(countryName)));
    driver.findElement(By.xpath(countryName)).click();
}
@AfterClass
    public void afterClass(){
    //driver.quit();
}
}
