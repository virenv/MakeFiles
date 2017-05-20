package tests.end2endScenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factories.WebDriverFactory;

public class TestScenario_3 {
		private WebDriver driver;
		
	/*
	 * This class demonstrates the usage of a browser Manager to deal with
	 * browser instances. With BrowserManager class we are able to hide out
	 * the details of browser management in one class. This also makes tests ignoratant
	 * of how driver instances are managed and who creates it
	 */
		
	@Test
	@Parameters({"browserType"})
	public void TS_3(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://shop.demoqa.com");
		
		WebElement myAccount = driver.findElement(By.linkText("MY ACCOUNT"));
		myAccount.click();
		
		WebElement userName = driver.findElement(By.cssSelector("#username"));
		userName.sendKeys("testuser_1");
		
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("Toolsqa@@00");

		WebElement login = driver.findElement(By.cssSelector("[name='login']"));
		login.submit();
		
		driver.get("http://shop.demoqa.com/product-category/dresses/");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
		Actions action = new Actions(driver);
	    action.moveToElement(items.get(0)).build().perform();
	    WebElement addToCart = driver.findElement(By.cssSelector(".add_to_cart_button"));
	    addToCart.click();
	    
	    WebElement continueShopping = driver.findElement(By.cssSelector(".close-popup"));
	    continueShopping.click();
	    
	    WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
	    action.moveToElement(cart).build().perform();
	    WebElement checkout = driver.findElement(By.cssSelector(".checkout-button"));
	    checkout.click();
	      
	    WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();
		
	    WebElement flatRate = driver.findElement(By.cssSelector("#shipping_method_0_flat_rate9[name='shipping_method[0]']"));
	    flatRate.click();
		
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		
		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(0).click();
		
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		
		myAccount.click();

		WebElement orders = driver.findElement(By.cssSelector(".woocommerce-MyAccount-navigation-link--orders"));
		orders.click();
		
		WebDriverFactory.QuitDriver();	
	}
}
