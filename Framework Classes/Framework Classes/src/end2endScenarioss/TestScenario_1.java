package end2endScenarioss;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScenario_1 {

	private static WebDriver driver;

	public static void main(String[] args) {	
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		WebElement search = driver.findElement(By.cssSelector(".noo-search"));
		search.click();
		
		WebElement performSearch = driver.findElement(By.cssSelector(".form-control"));
		performSearch.sendKeys("Dress");
		performSearch.sendKeys(Keys.ENTER);
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();
		
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();
				
		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();
		
		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();
		
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");
		
		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");
		
		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");
		
		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");
				
		WebElement country = driver.findElement(By.cssSelector("#s2id_billing_country .select2-arrow"));
		country.click();
		
		WebElement countryDropDown = driver.findElement(By.cssSelector("#select2-drop input"));
		countryDropDown.sendKeys("India ");
		countryDropDown.sendKeys(Keys.ENTER);
						
		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");
		
		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Delhi");
		
		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("Delhi");		
		
		//Select state = new Select(driver.findElement(By.cssSelector("#billing_state")));
		//state.selectByVisibleText("Delhi");
		
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		
		WebElement freeDelivery = driver.findElement(By.cssSelector("#shipping_method_0_free_shipping2[name='shipping_method[0]']"));
		freeDelivery.click();		
		
		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(0).click();
		
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		
		driver.quit();
				
	}

}
