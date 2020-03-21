package com.automation.tests.tutorialspoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    String message = "Greetings!!";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage()
    {
        System.out.println("Inside testPrintMessage()");
        Assert.assertEquals(message, messageUtil.printMessage());
    }
}
