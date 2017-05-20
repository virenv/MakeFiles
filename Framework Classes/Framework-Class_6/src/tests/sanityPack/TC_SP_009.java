package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import constants.ExcelConsts;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class TC_SP_009 extends BaseTest  {
	public TC_SP_009() throws IOException {
		super();
	}

	@Test
	public void Apply_Discount(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct(testDataReader.GetTestData(testName, ExcelConsts.ProductName));
		
		productPage.AddProductToCart(testDataReader.GetTestData(testName, ExcelConsts.ProductColor),
				testDataReader.GetTestData(testName, ExcelConsts.ProductSize));
		
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		cartPage.Enter_Discount(testDataReader.GetTestData(testName, ExcelConsts.DiscountCode));
		cartPage.ClickOn_Discount();

		Assert.assertTrue(cartPage.IsDisplayed_DiscountApplied(), "Discount Code is not applied on Cart Page");
	}

}
