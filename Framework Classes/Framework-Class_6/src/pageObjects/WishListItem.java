package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import reporters.Reporter;

public class WishListItem {
	private WebElement addToCart;
	
	public WishListItem(WebElement itemContainer){
		addToCart = itemContainer.findElement(By.cssSelector(".add_to_cart_button"));
	}
	
	public void AddToCart(){
		addToCart.click();
		Reporter.GetReporter().log(LogStatus.INFO, "Clicked Add to Cart on WishList Page");
	}


}
