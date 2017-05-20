package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

public class WishListPage extends BasePageObject{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	private List<WishListItem> items;
	
	@FindAll(@FindBy(how = How.CSS, using = "table tbody tr"))
	private List<WebElement> WishListItems;	
	
	public void NavigateToWishList(){
		driver.get("http://shop.demoqa.com/wishlist/");
	}
	
	public List<WishListItem> GetItems(){
		items = new ArrayList<WishListItem>(); 
		for(WebElement item : WishListItems){
			items.add(new WishListItem(item));
		}
		return items;
	}

}
