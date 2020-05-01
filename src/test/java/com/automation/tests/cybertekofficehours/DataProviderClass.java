package com.automation.tests.cybertekofficehours;

import org.testng.annotations.DataProvider;
public class DataProviderClass {
    @DataProvider(name="SearchProvider")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "Guru99", "India" },
                { "Krishna", "UK" },
                { "Bhupesh", "USA" }
        };
    }}