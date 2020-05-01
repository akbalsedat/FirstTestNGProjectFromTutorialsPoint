package com.automation.tests.cybertekofficehours;

import com.utilities.BrowserFactory;
import com.utilities.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.*;

public class DataProviderTest {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }

    @DataProvider(name= "testData")
    public static Object[][] testData() {
        return new Object[][]{{"404"}, {"500"}, {"301"}, {"200"}};
    }

    @Test (dataProvider = "testData")
    public void statusCodes(String code ){
        //Step 2
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText(code));
        BrowserUtil.wait(3);
        statusCode.click();
        BrowserUtil.wait(3);
        String expectedMessage ="This page returned a "+code+" status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
       /*
            The following is a HARD assertion and contains a message that is displayed only if the assertion fails.
            When a HARD assertion fails the rest of the script is skipped
        */
        Assert.assertTrue(actualMessage.contains(expectedMessage),"The status code does not exist");
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}