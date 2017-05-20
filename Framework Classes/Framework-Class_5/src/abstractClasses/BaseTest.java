package abstractClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentTest;
import dataProvider.ExcelTestDataReader;
import dataProvider.FileConfigReader;
import factories.ConfigReaderFactory;
import factories.WebDriverFactory;
import reporters.Reporter;
import utilities.Utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners(listeners.TestListener.class)
public abstract class BaseTest{
	protected WebDriver driver;
	protected FileConfigReader config;
	protected ExcelTestDataReader testDataReader;
	protected ExtentTest report;
	protected String testName;

	public BaseTest() throws IOException{
		config = ConfigReaderFactory.GetConfigReader();		
		testDataReader = ConfigReaderFactory.GetTestDataReader(); 		
	}	
	
	
	@BeforeSuite
	public void BeforeSuite(){
		Reporter.InitiateReporter(config.GetReportFilePath());
	}
	
	@BeforeMethod 
	public void beforeMethod(Method method){
		testName = Utils.GetTestName(this.getClass().getName());
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());
		report = Reporter.StartTest(testName);
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(config.GetEnvironmentUrl());		
	}
	
	@AfterMethod
	public void afterMethod(Method method) {
		WebDriverFactory.QuitDriver();
		Reporter.EndTest();
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.CloseReport();		
	}
	

}
