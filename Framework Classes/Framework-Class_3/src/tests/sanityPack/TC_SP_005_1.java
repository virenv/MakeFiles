package tests.sanityPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import pageObjects.CartPage_1;
import pageObjects.ProductPage;

public class TC_SP_005_1 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Update_Item_Quantity(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");		


		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage_1 cartPage = new CartPage_1(driver);
		cartPage.NavigateToCart();

		WebElement increaseQuantity = cartPage.GetItems().get(0).findElement(By.cssSelector(".icon_plus"));
		
		increaseQuantity.click();
		
		cartPage.ClickOn_UpdateCart();
		
		WebElement quanity = cartPage.GetItems().get(0).findElement(By.cssSelector(".product-quantity input"));
		Assert.assertTrue(quanity.getAttribute("value").equals("2"), "Quanity is not increased of the item");
		
		WebDriverFactory.QuitDriver();
	}
	

}
