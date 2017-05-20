package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

public class PageHeader extends BasePageObject {

	public PageHeader(WebDriver driver) {
		super(driver);
	}

	 @FindBy(how = How.CSS, using = ".noo-main-menu > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")
	 private WebElement MyAccount;
	 
	 @FindBy(how = How.CSS, using = ".noo-wishlist")
	 private WebElement WishList;
	 
	 public void ClickOn_MyAccount(){
		 MyAccount.click();
	 }
	 
	 public void ClickOn_WishList(){
		 WishList.click();
	 }
	 
	 
	  
}
