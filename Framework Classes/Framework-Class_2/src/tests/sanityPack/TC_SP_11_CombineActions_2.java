package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import pageObjects.LoginPage_2;

public class TC_SP_11_CombineActions_2 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void SignIn(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");		

		WebElement myAccount = driver.findElement(By.cssSelector(".noo-main-menu > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)"));
		myAccount.click();

        LoginPage_2 loginPage = new LoginPage_2(driver);
        loginPage.SignIn("rajesh", "Toolsqa@@00");
		
        WebElement dashBoard = driver.findElement(By.cssSelector(".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--dashboard"));
		Assert.assertTrue(dashBoard.isDisplayed(),"User is not Logged In");	
					
		WebDriverFactory.QuitDriver();
	}
	
}
