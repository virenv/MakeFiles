package end2endScenarioss;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TestScenario_4 {
	private static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://shop.demoqa.com");
		
		driver.get("http://shop.demoqa.com/product/tim-tim-stripe-dress/");
		
		Select colour = new Select(driver.findElement(By.cssSelector("select#pa_color")));
		colour.selectByValue("black");
		
		Select size = new Select(driver.findElement(By.cssSelector("select#pa_size")));
		size.selectByValue("12");
		
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();
		
		driver.get("http://shop.demoqa.com/checkout/");
		
		WebElement loginHere = driver.findElement(By.cssSelector(".showlogin"));
		loginHere.click();
		
		WebElement userName = driver.findElement(By.cssSelector("#username"));
		userName.sendKeys("testuser_1");
		
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Toolsqa@@00");

		WebElement login = driver.findElement(By.cssSelector("[name='login']"));
		login.submit();
		
		WebElement freeDelivery = driver.findElement(By.cssSelector("#shipping_method_0_free_shipping2[name='shipping_method[0]']"));
		boolean result = freeDelivery.isDisplayed();
		Assert.assertTrue("Free Delivery Displayed", result);
		
		driver.get("http://shop.demoqa.com/product/chantilly-bow-strappy-maxi-dress/");
		
		colour = new Select(driver.findElement(By.cssSelector("select#pa_color")));
		colour.selectByValue("black");
		
		size = new Select(driver.findElement(By.cssSelector("select#pa_size")));
		size.selectByValue("12");
		
		addToCart.click();
		
		driver.get("http://shop.demoqa.com/checkout/");
		
		freeDelivery = driver.findElement(By.cssSelector("#shipping_method_0_free_shipping2[name='shipping_method[0]']"));
		freeDelivery.click();	
		
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		
		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(1).click();
		
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();	
		
		driver.quit();
		
	}

}
