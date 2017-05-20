package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListItem {
	private WebElement addToCart;
	
	public WishListItem(WebElement itemContainer){
		addToCart = itemContainer.findElement(By.cssSelector(".add_to_cart_button"));
	}
	
	public void AddToCart(){
		addToCart.click();
	}


}
