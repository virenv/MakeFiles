package sanityPack;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TC_SP_002 {
	private static WebDriver driver;
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product/tim-tim-stripe-dress/");
		
		WebElement addToWishList = driver.findElement(By.cssSelector(".entry-summary .add_to_wishlist"));
		addToWishList.click();
		
	    WebElement wishList = driver.findElement(By.cssSelector(".noo-wishlist"));
	    wishList.click();
	    
		WebElement wishListItem = driver.findElement(By.cssSelector("table tbody"));
		List<WebElement> items = wishListItem.findElements(By.cssSelector("tr"));
		Assert.assertTrue("Item not moved to Wish List", !items.isEmpty());
		
		driver.quit();

	}

}
