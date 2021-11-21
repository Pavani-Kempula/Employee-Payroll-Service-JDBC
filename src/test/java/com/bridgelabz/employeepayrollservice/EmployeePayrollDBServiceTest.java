package com.bridgelabz.employeepayrollservice;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeePayrollDBServiceTest {
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
        Assert.assertEquals(6, employeePayrollDataList.size());
    }

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldnotMatchEmployeeCount() {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
        Assert.assertNotSame(4, employeePayrollDataList.size());
    }

    @Test
    public void givenNewEmployeeSalaryShouldUpdateWithDatabase() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollService
                .readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeBasic_pay("Pavani", 30000001.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Pavani");
        Assert.assertTrue(result);
    }
}