package tests.sanityPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.FileConfigReader;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.ProductPage;
import pageObjects.WishListPage;

public class TC_SP_007 {
	private WebDriver driver;

	@Test
	public void Move_Item_To_Cart_From_WishList() throws IOException {
		FileConfigReader config = new FileConfigReader();			
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(config.GetEnvironmentUrl());
		
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		productPage.ClickOn_AddToWishList();
		
		WishListPage wishListPage = new WishListPage(driver);
		wishListPage.NavigateToWishList();
		wishListPage.GetItems().get(0).AddToCart();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		
		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");	

		WebDriverFactory.QuitDriver();
	}

}
