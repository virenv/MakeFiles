package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

public class WishListPage extends BasePageObject{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "table tbody")
	private WebElement ItemsContainer;	
	
	private List<WebElement> items = ItemsContainer.findElements(By.cssSelector("tr")) ;
	
	public void NavigateToWishList(){
		driver.get("http://shop.demoqa.com/wishlist/");
	}
	
	public List<WebElement> GetItems(){
		return items;
	}

}
