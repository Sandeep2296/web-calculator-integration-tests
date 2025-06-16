package com.calculator.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.calculator.reports.ExtentManager;
import org.calculator.reports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTestManager.startTest(testName);
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed successfully");
    }

    public void onTestFailure(ITestResult result) {
        Throwable throwable = result.getThrowable();
        if(throwable!=null){
            ExtentTestManager.getTest().fail(throwable);
        }else {
            ExtentTestManager.getTest().fail("Test Failed");
        }
    }

    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}
