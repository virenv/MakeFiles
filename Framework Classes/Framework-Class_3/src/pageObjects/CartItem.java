package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartItem {
	
	private WebElement image;
	private WebElement name;
	private WebElement price;
	private WebElement quanityPlus;
	private WebElement quanityMinus;
	private WebElement quanity;
	private WebElement subTotal;
	private WebElement delete;
	
	public CartItem(WebElement itemContainer){
		image = itemContainer.findElement(By.cssSelector(".attachment-shop_thumbnail"));
		name = itemContainer.findElement(By.cssSelector(".product-name a"));
		price = itemContainer.findElement(By.cssSelector(".product-price .woocommerce-Price-amount"));
		quanity = itemContainer.findElement(By.cssSelector(".product-quantity input"));
		quanityPlus = itemContainer.findElement(By.cssSelector(".quantity .icon_plus"));
		quanityMinus = itemContainer.findElement(By.cssSelector(".quantity .icon_minus-06"));
		subTotal = itemContainer.findElement(By.cssSelector(".product-subtotal .woocommerce-Price-amount"));
		delete = itemContainer.findElement(By.cssSelector(".product-remove a"));	
	}
	
	public void DeleteItem(){
		delete.click();
	}
	
	public void IncreaseQuanity(){
		quanityPlus.click();
	}
		
	public String GetQuantity(){
		return quanity.getAttribute("value");
	}

}
