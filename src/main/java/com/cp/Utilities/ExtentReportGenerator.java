package com.cp.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cp.commonsActions.BaseTest;

public class ExtentReportGenerator extends BaseTest implements ITestListener {
	public Properties pro;
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		pro = new Properties();
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String reportName = "Demo Project" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser:", "Chrome");
		reports.setSystemInfo("user name:", "Vaishali Nandanwar");
		htmlReporter.config().setDocumentTitle("Project Report ");
		htmlReporter.config().setReportName("DemoProject Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("********Test Started**********" + Result.getName());
	}

	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked....");
		reports.flush();
	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, "TEST CASE FAIL & EXCEPTION IS  :" + Result.getThrowable());

		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File screenShotFile = new File(screenShotPath);
		if (screenShotFile.exists()) {
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		} else {
			try {
				String filePath = BaseTest.takesScreenshot(Result.getName());
				test.fail("Captured Screenshot :" + test.addScreenCaptureFromPath(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skipped:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("Name of test method started:" + Result.getName());
	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method sucessfully executed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}

}