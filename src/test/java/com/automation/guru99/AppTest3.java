package com.automation.guru99;
// https://www.guru99.com/implicit-explicit-waits-selenium.html

import com.utilities.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class AppTest3 {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String URL = "https://qa1.vytrack.com/user/login";
    private By seleniumLinkBy = By.xpath("//a[contains(text(), 'SELENIUM')]");

    private By cardProductLinkBy = By.cssSelector("a[class = card-product__link]");
    private By acceptCookieBy = By.cssSelector("button[data-pen-clickid = PF-BTN-CLK-GLOBAL-COOKIE-ACCEPT]");
    private By learnMoreBy = By.cssSelector("a[data-di-id= di-id-c0742cfb-52c6619b ]");
    private By continueBy = By.cssSelector("a[id = continue]");

    @Test (description = "Testing Wait class to see how it works")
    public void guru99Tutorials()
    {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Guru99 Page";

        Assert.assertEquals(actualTitle, expectedTitle, "No match");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);


        WebElement clickSeleniumLink = wait.until(new Function<WebDriver, WebElement>(){

            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(seleniumLinkBy);
            }
        });

        //click on the selenium link
        clickSeleniumLink.click();
    }

    @Test
    public void getListOfElements(){
        driver.findElement(acceptCookieBy).click();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        //driver.findElement(continueBy).click();
    }

    @Test(description = "Capturing reCaptcha images and storing them in a list.")
    public void verifyingGmailInputBoxes(){
        // click on "sign in" button
        driver.findElement(By.xpath("//ul[contains(@class,'h-c-header__cta-list header__nav--ltr')]//a[contains(@class,'h-c-header__nav-li-link')][contains(text(),'Sign in')]"));
        BrowserUtil.wait(10);
    }

    @Test(description = "Some more exercise")
    public void verifyDifferenceBtwAttributes(){
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("hello", Keys.ENTER);

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-error > div")));

        WebElement webElement = driver.findElement(By.cssSelector(".alert.alert-error > div"));
        String webElementText = webElement.getText();
        String expected = "Invalid user name or password.";
        Assert.assertEquals(webElementText, expected);
    }

    @BeforeMethod (description = "This is setup before any method starts.")
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
