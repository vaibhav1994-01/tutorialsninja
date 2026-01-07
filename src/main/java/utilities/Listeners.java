package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import utilities.Genericutils;

public class Listeners implements ITestListener {

	    ExtentReports extent = ExtentReportTestNG.getReportObject();
	    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {

	        ExtentTest test =
	                extent.createTest(result.getMethod().getMethodName());

	        extentTest.set(test);

	        extentTest.get().log(
	            Status.INFO,
	            "Test Started: " + result.getMethod().getMethodName()
	        );
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        extentTest.get().log(
	            Status.PASS,
	            "Test Passed: " + result.getMethod().getMethodName()
	        );
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        extentTest.get().log(
	            Status.FAIL,
	            "Test Failed: " + result.getMethod().getMethodName()
	        );
	        extentTest.get().log(
	            Status.FAIL,
	            result.getThrowable()
	        );

	        WebDriver driver = BaseClass.getDriver();

	        if (driver != null) {
	            try {
	                String base64Screenshot =
	                        Genericutils.captureScreenshot(
	                                driver,
	                                result.getMethod().getMethodName()
	                        );

	                extentTest.get().addScreenCaptureFromBase64String(
	                        base64Screenshot,
	                        "Failure Screenshot"
	                );

	            } catch (Exception e) {
	                extentTest.get().log(
	                    Status.WARNING,
	                    "Screenshot capture failed: " + e.getMessage()
	                );
	            }
	        }
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}
