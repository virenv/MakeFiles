package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import reporters.Reporter;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.GetReporter().log(LogStatus.PASS, "Test Successfully Passed for : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result){
		Reporter.GetReporter().log(LogStatus.FAIL, "Test Failed for : " + result.getName());
		Reporter.GetReporter().log(LogStatus.ERROR, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result){}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context){}

}
