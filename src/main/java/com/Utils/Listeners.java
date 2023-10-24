package com.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Listeners implements ITestListener{

        static ExtentReports report;
        ExtentTest test;

        public void onTestStart(ITestResult result) {
            //before each test case
            test = report.createTest(result.getMethod().getMethodName());
            ExtentFactory.getInstance().setExtent(test);
            ExtentFactory.getInstance().getExtent().log(Status.INFO,result.getMethod().getMethodName()+" test is in progress");
            MyLogger.startTestCase(result.getMethod().getMethodName());
            MyLogger.info(result.getMethod().getMethodName()+" executing...");

        }

        public void onTestSuccess(ITestResult result) {

            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
            ExtentFactory.getInstance().removeExtentObject();
            MyLogger.warn("Test Executed Succesfully");
        }

        public void onTestFailure(ITestResult result) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
            MyLogger.warn("TEST FILED !");

            //add screenshot for failed test.
            File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
            Date date = new Date();
            String actualDate = format.format(date);


            String screenshotPath = System.getProperty("user.dir")+
                    "/Reports/"+actualDate+".png";
            File dest = new File(screenshotPath);

            try {
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(actualDate+".png");
                ExtentFactory.getInstance().removeExtentObject();

            } catch (Exception e) {
                e.printStackTrace();

            }


        }

        public void onTestSkipped(ITestResult result) {
            ExtentFactory.getInstance().getExtent().log(Status.INFO,result.getMethod().getMethodName()+" test is in progress");
            ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
            MyLogger.warn("Test Skipped");
            ExtentFactory.getInstance().removeExtentObject();

        }



        public void onStart(ITestContext context) {
            try {
                report = ExtentReportNG.setupExtentReport();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onFinish(ITestContext context) {
            //close extent
            report.flush();
        }

    }