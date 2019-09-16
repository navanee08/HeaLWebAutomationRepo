package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class listeners implements ITestListener {
	base b = new base();

	public void onTestStart(ITestResult result) {				
	}

	public void onTestSuccess(ITestResult result) {				
	}

	/*
	 * public void onTestFailure(ITestResult result) { try {
	 * b.getScreenshot(result.getName()); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * System.out.println("Captured screenshot on test step failure"); }
	 */

	public void onTestSkipped(ITestResult result) {				
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {				
	}

	public void onStart(ITestContext context) {				
	}

	public void onFinish(ITestContext context) {				
	}
	
}

	