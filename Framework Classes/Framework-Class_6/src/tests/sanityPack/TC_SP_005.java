package tests.sanityPack;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractClasses.BaseTest;
import constants.ExcelConsts;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class TC_SP_005  extends BaseTest {
	public TC_SP_005() throws IOException {
		super();
	}
	
	@Test
	public void Update_Item_Quantity() {
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct(testDataReader.GetTestData(testName, ExcelConsts.ProductName));
		
		productPage.AddProductToCart(testDataReader.GetTestData(testName, ExcelConsts.ProductColor),
				testDataReader.GetTestData(testName, ExcelConsts.ProductSize));

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		
		cartPage.GetItems().get(0).IncreaseQuanity();
		cartPage.ClickOn_UpdateCart();
		
		Assert.assertTrue(cartPage.GetItems().get(0).GetQuantity().equals("2"), "Quanity is not increased in the Cart Page");
	}
	

}
