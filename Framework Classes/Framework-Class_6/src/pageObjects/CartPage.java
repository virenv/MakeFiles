package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import abstractClasses.BasePageObject;

public class CartPage extends BasePageObject {
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	private List<CartItem> items;	
	
	@FindBy(how = How.CSS, using = "table.cart tbody")
	private WebElement ItemsContainer;	
	
	@FindBy(how = How.CSS, using = ".cart-empty")
	private WebElement EmptyCartMessage;	
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement Checkout;
	
	@FindBy(how = How.CSS, using = "#noo_coupon_code")
	private WebElement DiscountCode;
	
	@FindBy(how = How.CSS, using = ".noo-apply-coupon")
	private WebElement ApplyDiscount;
	
	@FindBy(how = How.CSS, using = ".cart-discount")
	private WebElement DiscountLabel;
	
	@FindBy(how = How.CSS, using = ".empty-cart")
	private WebElement ClearCart;
	
	@FindBy(how = How.CSS, using = "[name='update_cart']")
	private WebElement UpdateCart;
	
	@FindAll(@FindBy(how = How.CSS, using = ".cart_item"))
	private List<WebElement> CartItems;	

	public void NavigateToCart(){
		driver.get("http://shop.demoqa.com/cart/");
		report.log(LogStatus.INFO, "Navigate to Cart Page");
	}
	
	public List<CartItem> GetItems(){
		items = new ArrayList<CartItem>(); 
		for(WebElement item : CartItems){
			items.add(new CartItem(item));
		}
		return items;
	}
	
	public Boolean IsDisplayed_EmptyCartMessage(){
		return EmptyCartMessage.isDisplayed();
	}
	
	public void ClickOn_Checkout(){
		Checkout.click();
		report.log(LogStatus.INFO, "Clicked on Checkout on Cart Page");
	}
	
	public void Enter_Discount(String discountCode){
		DiscountCode.sendKeys(discountCode);
		report.log(LogStatus.INFO, "Entered Discount Code as " + discountCode + " on Cart Page");
	}
	
	public void ClickOn_Discount(){
		ApplyDiscount.click();
		report.log(LogStatus.INFO, "Clicked on Apply Discount on Cart Page");
	}
	
	public boolean IsDisplayed_DiscountApplied(){
		return DiscountLabel.isDisplayed();
	}
	
	public void ClickOn_ClearCart(){
		ClearCart.click();
		report.log(LogStatus.INFO, "Clicked on Clear Cart on Cart Page");
	}
	
	public void ClickOn_UpdateCart(){
		UpdateCart.click();
		report.log(LogStatus.INFO, "Clicked on Update Cart on Cart Page");
	}
		

	


}
