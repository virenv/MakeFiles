package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductPage;


public class TC_SP_010 extends BaseTest {
	public TC_SP_010() throws IOException {
		super();
	}

	@Test
	public void Go_To_Checkout(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		cartPage.ClickOn_Checkout();
		
		Assert.assertTrue(driver.getTitle().contains("Checkout"));
	}

}
