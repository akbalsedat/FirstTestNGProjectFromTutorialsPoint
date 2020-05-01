package com.automation.tests.cybertekofficehours.javascriptexecutor;

import com.utilities.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UnderstandingJavaScriptExecutor {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (description = "javascript test")
    public void test1(){
        js.executeScript("document.getElementById('twotabsearchtextbox').value='wooden spoon'");
    }

    @Test(description = "get the page title (return a value)")
    public void test2(){
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println("pageTitle = " + pageTitle);
    }

    @Test(priority = 3, description = "clicking on an element")
    public void test3(){
        js.executeScript("document.getElementById('twotabsearchtextbox').value='wooden spoon'");
        js.executeScript("document.getElementsByClassName('nav-input')[0].click();");
    }

    @Test(priority = 4, description = "return URL")
    public void test4(){
        String url = js.executeScript("return document.URL").toString();
        System.out.println("url = " + url);
    }

    @Test(priority = 5, description = "return element text")
    public void test5(){
        String textelement = js.executeScript("return document.getElementsByClassName('nav-a')[6].innerText").toString();
        System.out.println("textelement = " + textelement);
    }
    @Test(priority = 6, description = "scroll into view example")
    public void scrolldownTest(){
        js.executeScript("document.getElementById('icp-touch-link-country').scrollIntoView();"); // might not work on old websites
    }

    @AfterMethod
    public void teardown(){
        if(driver != null)
            driver.quit();
        driver = null;
    }
}
