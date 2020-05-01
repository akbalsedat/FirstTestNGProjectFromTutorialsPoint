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

public class DataProviderTest2 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
    driver = BrowserFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://google.com");
    }

    /**
     * Test case to verify google search box
     * @param author
     * @param searchKey
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = DataProviderClass.class)
    public void testMethod(String author, String searchKey){
        WebElement searchText = driver.findElement(By.name("q"));
        // search value in google searchbox
        searchText.sendKeys(searchKey);
        System.out.println("Welcome -> " + author + " your search key is: " + searchKey);
        BrowserUtil.wait(3);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue+"--"+searchKey);
        searchText.clear();
        // Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
