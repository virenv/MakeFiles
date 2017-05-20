package tests.sanityPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import factories.WebDriverFactory;
import pageObjects.CartPage;
import pageObjects.ProductPage;

public class TC_SP_006 {
	private WebDriver driver;
	
	@Test
	@Parameters({"browserType"})
	public void Delete_Item(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");		

		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		
		productPage.Select_Color("black");
		productPage.Select_Size("12");
		productPage.ClickOn_AddToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		
		WebElement itemToDelete = cartPage.GetItems().get(0);
		itemToDelete.findElement(By.cssSelector(".product-remove a")).click();
		
		Assert.assertTrue(cartPage.IsDisplayed_EmptyCartMessage());

		WebDriverFactory.QuitDriver();
	}

}
