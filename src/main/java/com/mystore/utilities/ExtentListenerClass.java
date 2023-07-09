package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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


public class ExtentListenerClass implements ITestListener
{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-" + timestamp + ".html"; 
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//Reports" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		ReadConfig readConfig = new ReadConfig();
		
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("os", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("user name:", "Sagar");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
		
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On start method inviked....."); 
	}
	
	public void onFinish(ITestContext Result)
	{
		System.out.println("On finish method inviked....."); 
		reports.flush();
	}
	
	// When Test case get failed , this method called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());//create entry in HTML report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED ));
		
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File screenShotFile = new File(screenShotPath);
		
		if(screenShotFile.exists())
		{
			test.fail("Captured screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		}
		
		//test.addScreenCaptureFromPath(null);
	}
	
	
	// When Test case get skipped , this method called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP , MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.YELLOW ));
	}
	
	//When test case get started , this method called
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of the method started" + Result.getName());
	}
	
	//When Test case get passed, this method is called
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method succesfully executed:" + Result.getName() );
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is:" +Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{}
}
