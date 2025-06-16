package org.calculator.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final ExtentReports reports = ExtentManager.getInstance();


    public static void startTest(String testName){
        ExtentTest test = reports.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getTest(){
        return extentTest.get();
    }

}
