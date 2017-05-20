package sanityPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_SP_004 {
	private static WebDriver driver;
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product-category/dresses/");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
		Actions action = new Actions(driver);
	    action.moveToElement(items.get(0)).build().perform();
	    WebElement addToWishList = driver.findElement(By.cssSelector(".add_to_wishlist"));
	    addToWishList.click();
	    
	    driver.get("http://shop.demoqa.com/wishlist/");
		
		WebElement wishListItem = driver.findElement(By.cssSelector("table tbody"));
		items = wishListItem.findElements(By.cssSelector("tr"));
		Assert.assertTrue("Item not moved to Wish List", !items.isEmpty());
		
		driver.quit();
	}

}
