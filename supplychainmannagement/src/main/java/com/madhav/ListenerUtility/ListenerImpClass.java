package com.madhav.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.madhav.generic.baseutility.BaseClass;

public class ListenerImpClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public  static ExtentTest test;//we call it as per need wherever we want to call
	//and one more thing it will not take part in parallel execution so we need to make object utility
	//class as thread local class
	//we call it like as listener imp class.test to provide logs in place of sop statement 
	public  static ExtentReports report;// if u want to use this report in every test case so make this variable as static
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
				System.out.println("reportconfiguration");
				//test.log(Status.INFO, "reportconfiguratin");
				String time = new Date().toString().replace(" ", "_").replace(":", "_");
				//spark report config
				 spark =new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
					spark.config().setReportName("CRM report");
					spark.config().setTheme(Theme.DARK);

					//add Environment information and create test
					 report=new ExtentReports();
					report.attachReporter(spark);
					report.setSystemInfo("os", "Windows-10");
					report.setSystemInfo("BROWSER", "CHROME-100");
					//we have implemented this method to configure the report
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("reportbackup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//on test start method is going to execute before each test
		System.out.println("====>"+result.getMethod().getMethodName()+">=========START==========");
		 test=report.createTest(result.getMethod().getMethodName());//job of this line is go and
		 //insert one test case in extent report
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====>"+result.getMethod().getMethodName()+">=========END==========");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
		String sourcefile = ts.getScreenshotAs(OutputType.BASE64);
		Date date=new Date();
		String time = date.toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(sourcefile, testName+"_"+time);
		test.log(Status.FAIL, testName+">>>>+fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+"===> SKIPPED");
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
}