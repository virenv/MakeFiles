package tests.sanityPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.FileConfigReader;
import factories.WebDriverFactory;
import pageObjects.PageHeader;
import pageObjects.ProductPage;
import pageObjects.WishListPage;


public class TC_SP_002 {
	private WebDriver driver;
	
	@Test
	public void Add_Product_To_WishList() throws IOException {
		FileConfigReader config = new FileConfigReader();			
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());	
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(config.GetEnvironmentUrl());
		
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");		
		productPage.ClickOn_AddToWishList();
		
		PageHeader header = new PageHeader(driver);
		header.ClickOn_WishList();
	    
		WishListPage wishListPage = new WishListPage(driver);		
		Assert.assertTrue(!wishListPage.GetItems().isEmpty(),"Item not moved to Wish List");
		
		WebDriverFactory.QuitDriver();

	}

}
