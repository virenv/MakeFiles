package tests.sanityPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.FileConfigReader;
import factories.WebDriverFactory;
import pageObjects.CategoryPage;
import pageObjects.WishListPage;

public class TC_SP_004 {
	private WebDriver driver;
	
	@Test
	public void Add_To_WishList_QuickView() throws IOException {
		FileConfigReader config = new FileConfigReader();			
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(config.GetEnvironmentUrl());
		
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.NavigateToCategory("dress");
		categoryPage.GetItems().get(0).AddToWishList();
	    
	    WishListPage wishListPage = new WishListPage(driver);
		wishListPage.NavigateToWishList();
		
		Assert.assertTrue(!wishListPage.GetItems().isEmpty(),"Item not moved to Wish List");
		
		WebDriverFactory.QuitDriver();
	}

}
