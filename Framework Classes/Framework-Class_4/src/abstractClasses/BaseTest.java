package abstractClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import dataProvider.ExcelTestDataReader;
import dataProvider.FileConfigReader;
import factories.ConfigReaderFactory;
import factories.WebDriverFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest{
	protected WebDriver driver;
	protected FileConfigReader config;
	protected ExcelTestDataReader testDataReader;
	
	public BaseTest() throws IOException{
		config = ConfigReaderFactory.GetConfigReader();
		testDataReader = new ExcelTestDataReader(config.GetTestDataFilePath()); 
	}
	
	@BeforeMethod
	public void beforeMethod(Method method){
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(config.GetEnvironmentUrl());		
	}
	
	@AfterMethod
	public void afterMethod(Method method) {
		WebDriverFactory.QuitDriver();
	}

}
