package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import constants.ExcelConsts;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class TC_SP_008 extends BaseTest  {
	public TC_SP_008() throws IOException {
		super();
	}

	@Test
	public void Clear_Cart(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct(testDataReader.GetTestData(testName, ExcelConsts.ProductName));
		
		productPage.AddProductToCart(testDataReader.GetTestData(testName, ExcelConsts.ProductColor),
				testDataReader.GetTestData(testName, ExcelConsts.ProductSize));

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		cartPage.ClickOn_ClearCart();		
		
		Assert.assertTrue(cartPage.IsDisplayed_EmptyCartMessage(), "Cart is not Empty");
	}

}
