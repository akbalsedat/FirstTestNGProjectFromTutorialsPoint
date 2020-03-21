package com.automation.tests.tutorialspoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
    String message = "Greetings!!";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationMessage()
    {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi! " + "Greetings!!";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }
}
