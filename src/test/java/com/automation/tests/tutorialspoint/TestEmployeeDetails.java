package com.automation.tests.tutorialspoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeDetails {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employeeDetails = new EmployeeDetails();

    @Test
    public void testCalculateAppraisal(){
        employeeDetails.setName("Alex");
        employeeDetails.setAge(30);
        employeeDetails.setMonthlySalary(8000);

        double appraisal = empBusinessLogic.calculateAppraisal(employeeDetails);
        Assert.assertEquals(500, appraisal, 0.0, "500");
    }

    //Test to check yearly salary
    @Test
    public void testCalculateYearlySalary(){
        employeeDetails.setName("Alex");
        employeeDetails.setAge(30);
        employeeDetails.setMonthlySalary(8000);

        double salary = empBusinessLogic.calculateYearlySalary(employeeDetails);
        Assert.assertEquals(96000, salary, 0.0, "8000");
    }
}
