package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import constants.ExcelConsts;
import pageObjects.CategoryPage;
import pageObjects.WishListPage;

public class TC_SP_004  extends BaseTest  {
	public TC_SP_004() throws IOException {
		super();
	}
	
	@Test
	public void Add_To_WishList_QuickView() {
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.NavigateToCategory(testDataReader.GetTestData(testName, ExcelConsts.Search));
		categoryPage.GetItems().get(0).AddToWishList();
	    
	    WishListPage wishListPage = new WishListPage(driver);
		wishListPage.NavigateToWishList();
		
		Assert.assertTrue(!wishListPage.GetItems().isEmpty(), "Item not moved to Wish List");
	}

}
