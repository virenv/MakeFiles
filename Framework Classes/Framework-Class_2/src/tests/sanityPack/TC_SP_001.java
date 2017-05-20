package tests.sanityPack;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_SP_001 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Add_Product_To_Cart(String browserType) {
		
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product/tim-tim-stripe-dress/");
		
		Select colour = new Select(driver.findElement(By.cssSelector("select#pa_color")));
		colour.selectByValue("black");
		
		Select size = new Select(driver.findElement(By.cssSelector("select#pa_size")));
		size.selectByValue("12");
		
		WebElement addToCart = driver.findElement(By.cssSelector(".single_add_to_cart_button"));
		addToCart.submit();
		
		driver.get("http://shop.demoqa.com/cart/");
		
		WebElement cartItem = driver.findElement(By.cssSelector("table.cart tbody"));
		List<WebElement> items = cartItem.findElements(By.cssSelector(".cart_item"));

		Assert.assertTrue(!items.isEmpty(),"Item not moved to Cart");
		
		WebDriverFactory.QuitDriver();
	}

}
