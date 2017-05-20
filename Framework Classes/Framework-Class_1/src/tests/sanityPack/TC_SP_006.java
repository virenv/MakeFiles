package tests.sanityPack;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_SP_006 {
	private WebDriver driver;
	

	public  void Delete_Item() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product/tim-tim-stripe-dress/");
		
		Select colour = new Select(driver.findElement(By.cssSelector("select#pa_color")));
		colour.selectByValue("black");
		
		Select size = new Select(driver.findElement(By.cssSelector("select#pa_size")));
		size.selectByValue("12");
		
		WebElement addToCart = driver.findElement(By.cssSelector(".entry-summary .add_to_wishlist"));
		addToCart.click();
		
		driver.get("http://shop.demoqa.com/cart/");
		
		WebElement cartItem = driver.findElement(By.cssSelector("table.cart tbody"));
		List<WebElement> items = cartItem.findElements(By.cssSelector(".cart_item"));
		WebElement removeItem = items.get(0).findElement(By.cssSelector(".product-remove a"));
		removeItem.click();
		
		WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
		if(!emptyCartMessage.isDisplayed())throw new Exception("Cart is not Empty");

		driver.quit();
	}

}
