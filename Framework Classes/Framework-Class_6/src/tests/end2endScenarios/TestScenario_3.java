package tests.end2endScenarios;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import abstractClasses.BaseTest;
import constants.*;
import factories.WebDriverFactory;
import pageObjects.*;

public class TestScenario_3 extends BaseTest {
	public TestScenario_3() throws IOException {
		super();
	}
		
	@Test
	public void TS_3() {
		
		PageHeader header = new PageHeader(driver);
		header.ClickOn_MyAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.SignIn(testDataReader.GetTestData(testName, ExcelConsts.UserName), testDataReader.GetTestData(testName, ExcelConsts.Password));

		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.NavigateToCategory(testDataReader.GetTestData(testName, ExcelConsts.Search));
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-thumbnail-product.hover-device"));
		Actions action = new Actions(driver);
	    action.moveToElement(items.get(0)).build().perform();
	    WebElement addToCart = driver.findElement(By.cssSelector(".add_to_cart_button"));
	    addToCart.click();
	    
	    categoryPage.ContinueShopping();
	    header.GoToCheckoutFromMiniCart();
	    
	    CartPage cart = new CartPage(driver);
	    cart.ClickOn_Checkout();
	    
	    CheckoutPage checkout = new CheckoutPage(driver);
	    checkout.Select_FlatRate();
	    checkout.UnCheck_ShipToDifferentAddress();
	    checkout.Select_Payment(PaymentConsts.Check);
	    checkout.Check_TermsAndCondition();
		checkout.ClickOn_PlaceOrder();
		
		header.ClickOn_MyAccount();
		
		MyAccountPage myAccount = new MyAccountPage(driver);
		myAccount.ClickOn_Orders();
	
		WebDriverFactory.QuitDriver();	
	}
}
