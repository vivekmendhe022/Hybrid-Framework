package com.generic.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class contains Listeners abstract method to monitor each & every script
 * 
 * @author Vivek M
 *
 */
public class ListenersImplementationUtility implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script Start");

		test = reports.createTest(methodName);
		test.log(Status.INFO, methodName + " : Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script Passed");
		test.log(Status.PASS, methodName + " : Script Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script Failed");
		System.out.println(result.getThrowable());

		test.log(Status.FAIL, methodName + " : Script Failed");
		test.log(Status.WARNING, result.getThrowable());

		// Take Screen Shot
		String src = methodName + " - " + new JavaUtility().getSystemDateInFormate();
		WebDriverUtility wutil = new WebDriverUtility();
		try {
			String path = wutil.takeScreenShot(BaseClass.SDriver, src);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Start");
//		String path = ".\\ExtentReports\\Report - " + new JavaUtility().getSystemDateInFormate() + ".html";

		ExtentSparkReporter html = new ExtentSparkReporter(IConstantUtility.EXTENTREPORTPATH);
		html.config().setDocumentTitle("Application Extent Report");
		html.config().setReportName("Execution Report");
		html.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(html);
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base Paltform", "Windows 11");
		reports.setSystemInfo("Reporter Name", "Test Script Developer");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		reports.flush();
	}

}
