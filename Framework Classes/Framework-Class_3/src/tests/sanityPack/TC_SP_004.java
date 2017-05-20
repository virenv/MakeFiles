package tests.sanityPack;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factories.WebDriverFactory;
import pageObjects.WishListPage;

public class TC_SP_004 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Add_To_WishList_QuickView(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product-category/dresses/");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
	    WebElement addToWishList = items.get(0).findElement(By.cssSelector(".add_to_wishlist"));
	    addToWishList.click();
	    
	    WishListPage wishListPage = new WishListPage(driver);
		wishListPage.NavigateToWishList();
		
		Assert.assertTrue(!wishListPage.GetItems().isEmpty(),"Item not moved to Wish List");
		
		WebDriverFactory.QuitDriver();
	}

}
