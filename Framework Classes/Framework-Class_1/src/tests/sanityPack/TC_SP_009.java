package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_SP_009 {
	private WebDriver driver;


	public void Apply_Discount() throws Exception {
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
		
		WebElement discount = driver.findElement(By.cssSelector("#noo_coupon_code"));
		discount.sendKeys("cash_discount_10");
		
		WebElement applyDiscount = driver.findElement(By.cssSelector(".noo-apply-coupon"));
		applyDiscount.click();
		
		WebElement cartDiscount = driver.findElement(By.cssSelector(".cart-discount"));
		
		if(!cartDiscount.isDisplayed())throw new Exception("Discount is not applied");
		
		driver.quit();
	}

}
