package ai.ds.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ai.ds.testbase.TestBase;

public class ListenerSetup extends TestBase implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test Exection started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test Exection completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test Exection failed");
		UtilClass.takeSS(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test Exection Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
