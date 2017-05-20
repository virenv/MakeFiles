package tests.sanityPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.FileConfigReader;
import factories.WebDriverFactory;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.PageHeader;



public class TC_SP_011 {
	private WebDriver driver;

	@Test
	public void SignIn() throws IOException {
		FileConfigReader config = new FileConfigReader();			
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());	
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(config.GetEnvironmentUrl());		
		
		PageHeader header = new PageHeader(driver);
		header.ClickOn_MyAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.SignIn("rajesh", "Toolsqa@@00");
		
        MyAccountPage myAccount = new MyAccountPage(driver);
		Assert.assertTrue(myAccount.IsDisplayed_Dashboard(),"User is not Logged In");		
					
		WebDriverFactory.QuitDriver();
	}
	
}