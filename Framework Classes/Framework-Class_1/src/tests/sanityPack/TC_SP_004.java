package tests.sanityPack;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_SP_004 {
	private WebDriver driver;
	

	public void Add_To_WishList_QuickView() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product-category/dresses/");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
	    WebElement addToWishList = items.get(0).findElement(By.cssSelector(".add_to_wishlist"));
	    addToWishList.click();
	    
	    driver.get("http://shop.demoqa.com/wishlist/");
		
		WebElement wishListItem = driver.findElement(By.cssSelector("table tbody"));
		items = wishListItem.findElements(By.cssSelector("tr"));
		if(items.isEmpty())throw new Exception("Item not moved to Wish List");
		
		driver.quit();
	}

}
