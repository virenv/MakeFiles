package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class TC_SP_009 extends BaseTest  {
	public TC_SP_009() throws IOException {
		super();
	}

	@Test
	public void Apply_Discount(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		cartPage.Enter_Discount("cash_discount_10");
		cartPage.ClickOn_Discount();

		Assert.assertTrue(cartPage.IsDisplayed_DiscountApplied());
	}

}
