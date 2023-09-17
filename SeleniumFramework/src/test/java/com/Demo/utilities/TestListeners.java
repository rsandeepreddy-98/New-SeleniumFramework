package com.Demo.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListeners extends BaseClass implements ITestListener {
	ExtentReports extent = Reports.getReports();
	
	ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String method = result.getMethod().getMethodName();
		System.out.println("Method name = "+method);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.fail(result.getMethod().getMethodName());
		try {
			takeScreenshot(result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromPath(takeScreenshot(result.getMethod().getMethodName()));
		} catch (IOException e) {
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
