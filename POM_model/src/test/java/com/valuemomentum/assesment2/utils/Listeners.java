package com.valuemomentum.assesment2.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

 

 

 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

 

 

 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.valuemomentum.assesment2.utils.WebDriverHelper;

 

 

 


public class Listeners implements ITestListener{

 

 

 

    protected static ExtentReports reports;
    protected static ExtentTest test;
    protected  ExtentSparkReporter spark;
    
    public void onTestStart(ITestResult result) {
        test=reports.createTest(result.getMethod().getMethodName());
    }

 

 

 

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,result.getMethod().getMethodName()+"Test Passed");
    }

 

 

 

    public void onTestFailure(ITestResult result) {
        test.log(Status.PASS,result.getMethod().getMethodName()+"Test Failed");
//test screen shot code here
        WebDriverHelper.ScreenShot(result.getMethod().getMethodName());
        test= test.addScreenCaptureFromPath("C:\\Training\\Java\\TestAutomation\\screenshot\\"
        +result.getMethod().getMethodName()+".png");
    test.log(Status.FAIL,"test Failed");
    test.log(Status.FAIL, "\"C:\\Testing\\screenshot\\pm"+result.getMethod().getMethodName()+".png");
    }
    

 

 

 

    public void onTestSkipped(ITestResult result) {
        test.log(Status.PASS,result.getMethod().getMethodName()+"Test Skipped");
    }

 

 

 

 

 

 

    public void onStart(ITestContext context) {
         reports=new ExtentReports();
         spark=new ExtentSparkReporter("target/"+
         new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms").format(new Date())+"reports.html");
    }
    public void onFinish(ITestContext context) {
        reports.attachReporter(spark);
        reports.flush();
    }

 

 

 

}