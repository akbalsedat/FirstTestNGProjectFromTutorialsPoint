package com.automation.tests.exceptiontest;
//https://www.tutorialspoint.com/testng/testng_dependency_test.htm (source website)
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpectedExceptionTest {
    String message = "Baltimore";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test (expectedExceptions = ArithmeticException.class)
    public void testPrintMessage()
    {
        System.out.println("Inside testPrintMessage()");
        messageUtil.printMessage();
    }

    @Test
    public void testSalutationMessage()
    {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Baltimore";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }
}
