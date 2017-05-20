package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import constants.ExcelConsts;
import pageObjects.CartPage;
import pageObjects.ProductPage;
import pageObjects.WishListPage;

public class TC_SP_007 extends BaseTest {
	public TC_SP_007() throws IOException {
		super();
	}

	@Test
	public void Move_Item_To_Cart_From_WishList() {
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct(testDataReader.GetTestData(testName, ExcelConsts.ProductName));
		productPage.ClickOn_AddToWishList();
		
		WishListPage wishListPage = new WishListPage(driver);
		wishListPage.NavigateToWishList();
		wishListPage.GetItems().get(0).AddToCart();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		
		Assert.assertTrue(!cartPage.GetItems().isEmpty(), "Item not moved to Cart from Wish List");	
	}

}
