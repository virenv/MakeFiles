package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.PageHeader;

public class TC_SP_011_2 extends BaseTest {
	public TC_SP_011_2() throws IOException {
		super();
	}
	
	@Test
	public void SignIn(){	
		
		PageHeader header = new PageHeader(driver);
		header.ClickOn_MyAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.SignIn("rajesh", "Toolsqa@@00");
		
        MyAccountPage myAccount = new MyAccountPage(driver);
		Assert.assertTrue(myAccount.IsDisplayed_Dashboard(),"User is not Logged In");		
	}
	
}