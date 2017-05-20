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


public class TC_SP_002 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Add_Product_To_WishList(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product/tim-tim-stripe-dress/");
		
		WebElement addToWishList = driver.findElement(By.cssSelector(".entry-summary .add_to_wishlist"));
		addToWishList.click();
		
	    WebElement wishList = driver.findElement(By.cssSelector(".noo-wishlist"));
	    wishList.click();
	    
		WebElement wishListItem = driver.findElement(By.cssSelector("table tbody"));
		List<WebElement> items = wishListItem.findElements(By.cssSelector("tr"));
		Assert.assertTrue(!items.isEmpty(),"Item not moved to Wish List");
		
		WebDriverFactory.QuitDriver();

	}

}
