package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;


public class TC_SP_011 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void SignIn(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		WebElement myAccount = driver.findElement(By.cssSelector(".noo-main-menu > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)"));
		myAccount.click();
		
		WebElement userName = driver.findElement(By.cssSelector("#username"));
		userName.sendKeys("rajesh");
		
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Toolsqa@@00");

		WebElement login = driver.findElement(By.cssSelector(".button[value='Login']"));
		login.submit();
		
		WebElement dashBoard = driver.findElement(By.cssSelector(".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--dashboard"));
		Assert.assertTrue(dashBoard.isDisplayed());		
		
		WebDriverFactory.QuitDriver();
	}
	
}
