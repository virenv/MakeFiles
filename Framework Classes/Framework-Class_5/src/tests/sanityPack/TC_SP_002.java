package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.PageHeader;
import pageObjects.ProductPage;
import pageObjects.WishListPage;


public class TC_SP_002  extends BaseTest  {
	public TC_SP_002() throws IOException {
		super();
	}
	
	@Test
	public void Add_Product_To_WishList(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");		
		productPage.ClickOn_AddToWishList();
		
		PageHeader header = new PageHeader(driver);
		header.ClickOn_WishList();
	    
		WishListPage wishListPage = new WishListPage(driver);		
		Assert.assertTrue(!wishListPage.GetItems().isEmpty(),"Item not moved to Wish List");
	}

}
