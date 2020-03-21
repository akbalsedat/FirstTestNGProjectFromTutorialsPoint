package com.automation.tests.tutorialspoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTest {
    String message = "Greetings!!";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(enabled = false)
    public void testPrintMessage(){
        System.out.println("Inside testPrintMessage()");
        message = "Greetings!!";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void testSalutationMessage()
    {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi! " + "Greetings!!";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

}
