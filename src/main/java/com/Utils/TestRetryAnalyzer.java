package com.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.Utils.GetProperty.getProp;

public class TestRetryAnalyzer implements IRetryAnalyzer {


    int counter = 1;
    int retryMaxLimit = Integer.parseInt(getProp("retryCount"));


    @Override
    public boolean retry(ITestResult result) {
        if(counter<retryMaxLimit) {
            counter++;
            return true;
        }
        return false;
    }

}