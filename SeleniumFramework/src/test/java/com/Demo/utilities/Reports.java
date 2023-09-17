package com.Demo.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports extentReports;

	public static ExtentReports getReports() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String name = "Time-Stamp"+timeStamp+".html";
		String path = System.getProperty("user.dir")+"./Reports/Reports.html-"+name;
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Automation Demo Practise");
		extentSparkReporter.config().setDocumentTitle("Automation Practise");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Sandeep");
		return extentReports;
	}
}
