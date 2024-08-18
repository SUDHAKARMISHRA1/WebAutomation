package com.WebAutomation.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject() {
		
		//code to set the meta data like report name, test name with the help of ExtentSparkReporter.
		String path =System.getProperty("user.dir")+"//TestReports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Fundhouse Test Executation Reports");
		reporter.config().setDocumentTitle("AutomationTesting Report");
		reporter.config().setTheme(Theme.DARK);
	

		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Test User");
		extent.setSystemInfo("Test Engineers", "Sudhakar Mishra");
		return extent;
	}
}
