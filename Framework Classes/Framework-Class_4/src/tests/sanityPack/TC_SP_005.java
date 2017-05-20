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

public class TC_SP_005 {
	private WebDriver driver;
	
	@Test
	public void Update_Item_Quantity() throws IOException {
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
		
		cartPage.GetItems().get(0).IncreaseQuanity();
		cartPage.ClickOn_UpdateCart();
		
		Assert.assertTrue(cartPage.GetItems().get(0).GetQuantity().equals("2"), "Quanity is not increased in the Cart Page");
		
		WebDriverFactory.QuitDriver();
	}
	

}
