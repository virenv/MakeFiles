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

public class TC_SP_003 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Add_To_Cart_From_QuickView(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/?s=dress&post_type=product");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
	    WebElement addToCart = items.get(0).findElement(By.cssSelector(".add_to_cart_button"));
	    addToCart.click();
	    
	    driver.get("http://shop.demoqa.com/cart/");
		
		WebElement cartItem = driver.findElement(By.cssSelector("table.cart tbody"));
		items = cartItem.findElements(By.cssSelector(".cart_item"));
		Assert.assertTrue(!items.isEmpty(),"Item not moved to Cart");
		
		WebDriverFactory.QuitDriver();
	}

}
