package com.automation.tests.dependencytest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestUsingGroupAnnotation {
    String message = "Baltimore";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = { "init" })
    public void testPrintMessage(){
        System.out.println("Inside testPrintMessage() ");
        message = "Baltimore";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testSalutationMessage(){
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Baltimore";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

    @Test(groups = {"init"})
    public void initEnvironmentTest(){
        System.out.println("This is initEnvironmentTest");
    }
}
