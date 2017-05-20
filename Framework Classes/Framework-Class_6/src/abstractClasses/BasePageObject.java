package abstractClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import reporters.Reporter;

public abstract class BasePageObject {
	protected WebDriver driver;
	protected ExtentTest report;
	
	public BasePageObject(WebDriver driver){
		this.driver = driver;
		report = Reporter.GetReporter();
		PageFactory.initElements(driver, this);
	}
	
}
