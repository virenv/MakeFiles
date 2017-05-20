package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class TC_SP_005  extends BaseTest {
	public TC_SP_005() throws IOException {
		super();
	}
	
	@Test
	public void Update_Item_Quantity() {
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		
		cartPage.GetItems().get(0).IncreaseQuanity();
		cartPage.ClickOn_UpdateCart();
		
		Assert.assertTrue(cartPage.GetItems().get(0).GetQuantity().equals("2"), "Quanity is not increased in the Cart Page");
	}
	

}
