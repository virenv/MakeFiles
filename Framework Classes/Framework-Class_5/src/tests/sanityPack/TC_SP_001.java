package tests.sanityPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductPage;

import java.io.IOException;

public class TC_SP_001 extends BaseTest {
	
	public TC_SP_001() throws IOException {
		super();
	}
	
	@Test
	public void Add_Product_To_Cart(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();

		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");
	}

}
