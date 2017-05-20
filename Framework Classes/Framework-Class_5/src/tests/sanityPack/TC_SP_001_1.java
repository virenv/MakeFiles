package tests.sanityPack;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import abstractClasses.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductPage;

import java.io.IOException;

public class TC_SP_001_1 extends BaseTest {
	
	public TC_SP_001_1() throws IOException {
		super();
	}
	
	@Test
	public void Add_Product_To_Cart(){
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		report.log(LogStatus.INFO, "Navigate to Product Page");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();
		report.log(LogStatus.INFO, "Added Product to Cart");

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		report.log(LogStatus.INFO, "Navigate to Cart Page");

		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");
		report.log(LogStatus.PASS,"Item successfully moved to Cart");	
	}

}
