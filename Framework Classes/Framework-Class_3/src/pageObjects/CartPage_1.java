package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

public class CartPage_1 extends BasePageObject {
	
	public CartPage_1(WebDriver driver) {
		super(driver);
	}
	
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
	}
	
	//List of Items
	public List<WebElement> GetItems(){
		return CartItems;
	}
	
	public Boolean IsDisplayed_EmptyCartMessage(){
		return EmptyCartMessage.isDisplayed();
	}
	
	public void ClickOn_Checkout(){
		Checkout.click();
	}
	
	public void Enter_Discount(String discountCode){
		DiscountCode.sendKeys(discountCode);
	}
	
	public void ClickOn_Discount(){
		ApplyDiscount.click();
	}
	
	public boolean IsDisplayed_DiscountApplied(){
		return DiscountLabel.isDisplayed();
	}
	
	public void ClickOn_ClearCart(){
		ClearCart.click();
	}
	
	public void ClickOn_UpdateCart(){
		UpdateCart.click();
	}

}
