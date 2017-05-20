package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import abstractClasses.BasePageObject;

public class ProductPage extends BasePageObject {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "select#pa_color")
	private WebElement Color;		
	
	@FindBy(how = How.CSS, using = "select#pa_size")
	private WebElement Size;	
	
	@FindBy(how = How.CSS, using = ".single_add_to_cart_button")
	private WebElement AddToCart;
	
	@FindBy(how = How.CSS, using = ".entry-summary .add_to_wishlist")
	private WebElement AddToWishList;
	
	public void NavigateToProduct(String productName){
		driver.get("http://shop.demoqa.com/product/" + productName);
	}
	
	public void Select_Color(String color){
		new Select(Color).selectByValue(color);
	}
	
	public void Select_Size(String size){
		new Select(Size).selectByValue(size);
	}
	
	public void ClickOn_AddToCart(){
		AddToCart.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClickOn_AddToWishList(){
		AddToCart.click();
	}
		
}
