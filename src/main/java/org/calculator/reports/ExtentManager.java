package org.calculator.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance(){
        if(extentReports ==null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            reporter.config().setDocumentTitle("Web calculator integration test suite");
            reporter.config().setDocumentTitle("Integration suite");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Tester","Sandeep Sugumaran");
        }
        return extentReports;
    }

}
