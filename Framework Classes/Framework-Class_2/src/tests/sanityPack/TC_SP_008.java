package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factories.WebDriverFactory;

public class TC_SP_008 {
	private WebDriver driver;

	@Test
	@Parameters({"browserType"})
	public void Clear_Cart(String browserType){
		driver = WebDriverFactory.GetDriver(browserType);		
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
		
		WebElement clearCart = driver.findElement(By.cssSelector(".empty-cart"));
		clearCart.click();
		
		WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
		Assert.assertTrue(emptyCartMessage.isDisplayed(),"Cart is not Empty");

		WebDriverFactory.QuitDriver();
	}

}
