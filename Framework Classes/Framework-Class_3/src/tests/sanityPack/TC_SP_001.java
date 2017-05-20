package tests.sanityPack;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.ProductPage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class TC_SP_001 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Add_Product_To_Cart(String browserType) {
		
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

		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");
		
		WebDriverFactory.QuitDriver();
	}

}
