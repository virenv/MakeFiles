package tests.sanityPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataProvider.FileConfigReader;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.CategoryPage;

public class TC_SP_003 {
	private WebDriver driver;
	
	@Test
	public void Add_To_Cart_From_QuickView() throws IOException {
		FileConfigReader config = new FileConfigReader();			
		driver = WebDriverFactory.GetDriver(config.GetBrowserType());
		driver.manage().timeouts().implicitlyWait(config.GetImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(config.GetEnvironmentUrl());
		
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.SearchFor("dress");
		categoryPage.GetItems().get(0).AddToCart();
	    
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();

		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");
		
		WebDriverFactory.QuitDriver();
	}

}
