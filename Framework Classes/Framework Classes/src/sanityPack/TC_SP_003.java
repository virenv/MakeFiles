package sanityPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_SP_003 {
	private static WebDriver driver;
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/?s=dress&post_type=product");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
		Actions action = new Actions(driver);
	    action.moveToElement(items.get(0));
	    WebElement addToCart = driver.findElement(By.cssSelector(".add_to_cart_button"));
	    //addToCart.click();
	    action.moveToElement(addToCart);
	    action.click().build().perform();
	    
	    driver.get("http://shop.demoqa.com/cart/");
		
		WebElement cartItem = driver.findElement(By.cssSelector("table.cart tbody"));
		items = cartItem.findElements(By.cssSelector(".cart_item"));
		Assert.assertTrue("Item not moved to Cart", !items.isEmpty());
		
		driver.close();
		driver.quit();
	}

}
