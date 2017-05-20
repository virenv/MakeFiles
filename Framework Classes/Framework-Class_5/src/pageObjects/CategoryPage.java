package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

public class CategoryPage extends BasePageObject {

	public CategoryPage(WebDriver driver) {
		super(driver);
	}
	
	private List<CategoryItem> items;
	
	@FindAll(@FindBy(how = How.CSS, using = ".noo-thumbnail-product.hover-device"))
	private List<WebElement> CategoryItems;	
	
	public List<CategoryItem> GetItems(){
		items = new ArrayList<CategoryItem>(); 
		for(WebElement item : CategoryItems){
			items.add(new CategoryItem(item));
		}
		return items;
	}
	
	public void SearchFor(String searchString){
		driver.get("http://shop.demoqa.com/?s=" + searchString + "&post_type=product");
	}
	
	public void NavigateToCategory(String category){
		driver.get("http://shop.demoqa.com/product-category/" + category + "/");
	}
	


}
