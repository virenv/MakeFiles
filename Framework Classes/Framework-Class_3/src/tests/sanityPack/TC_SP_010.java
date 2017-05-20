package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.ProductPage;


public class TC_SP_010 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Go_To_Checkout(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		cartPage.ClickOn_Checkout();
		
		Assert.assertTrue(driver.getTitle().contains("Checkout"));

		WebDriverFactory.QuitDriver();
	}

}
