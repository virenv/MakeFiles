package tests.end2endScenarios;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import abstractClasses.BaseTest;
import constants.ExcelConsts;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.CategoryPage;
import pageObjects.PageHeader;

public class TestScenario_1 extends BaseTest  {

	public TestScenario_1() throws IOException {
		super();
	}
	
	@Test	
	public void TS_1() {	
		PageHeader header = new PageHeader(driver);
		header.PerformSearch(testDataReader.GetTestData(testName, ExcelConsts.Search));
		
		CategoryPage categoryPage = new CategoryPage(driver);
		categoryPage.GetItems().get(0).AddToCart();
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();
		
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();
				
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		cartPage.ClickOn_Checkout();
		
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");
		
		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");
		
		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");
		
		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");
				
		WebElement country = driver.findElement(By.cssSelector("#s2id_billing_country .select2-arrow"));
		country.click();
		
		WebElement countryDropDown = driver.findElement(By.cssSelector("#select2-drop input"));
		countryDropDown.sendKeys("India ");
		countryDropDown.sendKeys(Keys.ENTER);
						
		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");
		
		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Delhi");
		
		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("Delhi");		
		
		//Select state = new Select(driver.findElement(By.cssSelector("#billing_state")));
		//state.selectByVisibleText("Delhi");
		
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		
		WebElement freeDelivery = driver.findElement(By.cssSelector("#shipping_method_0_free_shipping2[name='shipping_method[0]']"));
		freeDelivery.click();		
		
		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(0).click();
		
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		
		WebDriverFactory.QuitDriver();
				
	}

}
