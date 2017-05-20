package tests.sanityPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import constants.ExcelConsts;
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
		productPage.NavigateToProduct(testDataReader.GetTestData(testName, ExcelConsts.ProductName));
		
		productPage.AddProductToCart(testDataReader.GetTestData(testName, ExcelConsts.ProductColor),
				testDataReader.GetTestData(testName, ExcelConsts.ProductSize));

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();

		Assert.assertTrue(!cartPage.GetItems().isEmpty(), "Item not moved to Cart");
	}

}
