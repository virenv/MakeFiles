package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import pageObjects.PageHeader;
import pageObjects.ProductPage;
import pageObjects.WishListPage;


public class TC_SP_002 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Add_Product_To_WishList(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
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
