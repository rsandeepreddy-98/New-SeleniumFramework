package com.Demo.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports extentReports;

	public static ExtentReports getReports() {
		String path = System.getProperty("user.dir")+"./Reports/report.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Automation Demo Practise");
		extentSparkReporter.config().setDocumentTitle("Automation Practise");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Sandeep");
		return extentReports;
	}
}
