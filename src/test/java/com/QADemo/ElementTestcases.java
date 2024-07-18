package com.QADemo;

import Utils.SeleniumBaseTest;
import org.testng.annotations.*;
import com.QADemo.pageObjects.ElementPageObject;

public class ElementTestcases  extends SeleniumBaseTest {
    ElementPageObject registerPageObject;



    @BeforeTest()
    public void beforeTest() {

    }

    @Test
    public void textBox() {
        logger.info("Step 1: click To 'Element' Menu button");
    }

    @Test
    public void checkbox() {

    }

    @AfterTest
    public void afterTest() {
    }
}
