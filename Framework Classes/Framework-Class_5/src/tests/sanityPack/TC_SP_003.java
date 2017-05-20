package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.CartPage;
import pageObjects.CategoryPage;

public class TC_SP_003  extends BaseTest {
	public TC_SP_003() throws IOException {
		super();
	}
	
	@Test
	public void Add_To_Cart_From_QuickView(){
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.SearchFor("dress");
		categoryPage.GetItems().get(0).AddToCart();
	    
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();

		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");
	}

}
