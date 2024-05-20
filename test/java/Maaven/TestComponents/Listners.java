 package Maaven.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReportNG;

public class Listners extends  BaseTest implements ITestListener {
  ExtentTest test;
  
  ExtentReports extent = ExtentReportNG.getReportObject();
  
  public void onTestStart(ITestResult result) {
	  test = extent.createTest(result.getMethod().getMethodName());
	  }
  
  @Override
  public void onTestSuccess(ITestResult result) {
	  test.log(Status.PASS, "Test passed");
      }
  
   @Override
	public void onTestFailure(ITestResult result) {
			// Screenshot code
			test.fail(result.getThrowable()); // to get the error msg
			
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String filePath = null;
			try {
				filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			}catch (IOException e) {
				e.printStackTrace();
			}// test case name
			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		}
}
