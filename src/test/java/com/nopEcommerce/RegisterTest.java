package com.nopEcommerce;

import com.nopEcommerce.pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    @BeforeMethod
    public void beforeMethod(){
        RegisterPageObject registerPageObject = new RegisterPageObject();
    }

    @Test
    public void registerWithEmptyData(){

    }
}
