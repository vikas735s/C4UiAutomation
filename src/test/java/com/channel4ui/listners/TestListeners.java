package com.channel4ui.listners;


import org.testng.*;

import java.util.Set;

public class TestListeners implements ITestListener{

    public void onTestStart(ITestResult iTestResult) {

    }



    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("Test Case - " + iTestResult.getMethod().getMethodName() + " PASSED");
    }

    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log("Test Case - " + iTestResult.getMethod().getMethodName() + "FAILED");
    }



    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
