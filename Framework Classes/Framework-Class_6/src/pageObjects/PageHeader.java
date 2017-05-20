package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import abstractClasses.BasePageObject;

public class PageHeader extends BasePageObject {

	public PageHeader(WebDriver driver) {
		super(driver);
	}

	 @FindBy(how = How.CSS, using = ".noo-main-menu > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")
	 private WebElement MyAccount;
	 
	 @FindBy(how = How.CSS, using = ".noo-wishlist")
	 private WebElement WishList;
	 
	 @FindBy(how = How.CSS, using = ".noo-search")
	 private WebElement Search;
	 
	 @FindBy(how = How.CSS, using = ".form-control")
	 private WebElement SearchBox;
	 
	 @FindBy(how = How.CSS, using = ".cart-button")
	 private WebElement Cart;
	 
	 @FindBy(how = How.CSS, using = ".checkout-button")
	 private WebElement CheckOut;
	 
	 public void ClickOn_MyAccount(){
		 MyAccount.click();
		 report.log(LogStatus.INFO, "Clicked on MyAccount from the Header");
	 }
	 
	 public void ClickOn_WishList(){
		 WishList.click();
		 report.log(LogStatus.INFO, "Clicked on WishList from the Header");
	 }
	 
	 public void PerformSearch(String searchString){
		 Search.click();
		 SearchBox.click();
		 SearchBox.sendKeys(searchString);
		 SearchBox.sendKeys(Keys.ENTER);
		 
		 report.log(LogStatus.INFO, "Performed Search from Header");
	 }
	 
	 public void GoToCheckoutFromMiniCart(){
		 	Actions action = new Actions(driver);
		    action.moveToElement(Cart).build().perform();
		    CheckOut.click();
		    report.log(LogStatus.INFO, "Moved to Checkout Page from Mini Cart");
	 }
	 
	 
	  
}
