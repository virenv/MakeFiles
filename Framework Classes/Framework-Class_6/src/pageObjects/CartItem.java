package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import reporters.Reporter;

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
		Reporter.GetReporter().log(LogStatus.INFO, "Clicked Delete on Cart Page");
	}
	
	public void IncreaseQuanity(){
		quanityPlus.click();
		Reporter.GetReporter().log(LogStatus.INFO, "Clicked Increase Quantity on Cart Page");
	}
	
	public void DecreaseQuanity(){		
		quanityMinus.click();
		Reporter.GetReporter().log(LogStatus.INFO, "Clicked Decreased Quantity on Cart Page");
	}
		
	public String GetQuantity(){		
		return quanity.getAttribute("value");	
	}
	
	public boolean IsDisplayedImage(){
		return image.isDisplayed();
	}

	public String GetName(){
		return name.getText();
	}
	
	public String GetPrice(){
		return price.getText();
	}
	
	public String GetSubTotal(){
		return subTotal.getText();
	}
}
