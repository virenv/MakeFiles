package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import reporters.Reporter;

public class CategoryItem {
	private WebElement addToCart;
	private WebElement addToWishList;
	
	public CategoryItem(WebElement itemContainer){
		addToCart = itemContainer.findElement(By.cssSelector(".add_to_cart_button"));
		addToWishList = itemContainer.findElement(By.cssSelector(".add_to_cart_button"));
	}
	
	public void AddToCart(){
		//Code to do mouse hover and perform add to cart
		//This will be done using Javascript, will be covered in some class
		addToCart.click();
		Reporter.GetReporter().log(LogStatus.INFO, "Clicked Add to Cart using JS on Category Page");
		
	}
	
	public void AddToWishList(){
		//Code to do mouse hover and perform add to cart
		//This will be done using Javascript, will be covered in some class
		addToWishList.click();
		Reporter.GetReporter().log(LogStatus.INFO, "Clicked Add to WishList using JS on Category Page");
	}
}
