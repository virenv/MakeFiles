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

public class TC_SP_007 {
	private WebDriver driver;

	@Test
	@Parameters({"browserType"})
	public void Move_Item_To_Cart_From_WishList(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product/tim-tim-stripe-dress/");
		
		WebElement addToWishList = driver.findElement(By.cssSelector(".entry-summary .add_to_wishlist"));
		addToWishList.click();
		
		driver.get("http://shop.demoqa.com/wishlist/");
		
		WebElement wishListItem = driver.findElement(By.cssSelector("table tbody"));
		List<WebElement> items = wishListItem.findElements(By.cssSelector("tr"));
		WebElement addToCart = items.get(0).findElement(By.cssSelector(".add_to_cart_button"));
		addToCart.click();
		
		driver.get("http://shop.demoqa.com/cart/");
		
		WebElement cartItem = driver.findElement(By.cssSelector("table.cart tbody"));
		items = cartItem.findElements(By.cssSelector(".cart_item"));
		Assert.assertTrue(!items.isEmpty(),"Item not moved to Cart");	

		WebDriverFactory.QuitDriver();
	}

}
