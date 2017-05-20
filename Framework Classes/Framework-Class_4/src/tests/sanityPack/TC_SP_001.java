package tests.sanityPack;

import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.FileConfigReader;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.ProductPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class TC_SP_001 {
	private WebDriver driver;
	
	@Test
	public void Add_Product_To_Cart() throws IOException {
		FileConfigReader config = new FileConfigReader();			
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(config.GetEnvironmentUrl());
		
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
