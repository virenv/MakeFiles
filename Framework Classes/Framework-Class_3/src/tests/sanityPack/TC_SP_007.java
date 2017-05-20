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
import pageObjects.WishListPage;

public class TC_SP_007 {
	private WebDriver driver;

	@Test
	@Parameters({"browserType"})
	public void Move_Item_To_Cart_From_WishList(String browserType) {
		driver = WebDriverFactory.GetDriver(browserType);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		
		ProductPage productPage = new ProductPage(driver);
		productPage.NavigateToProduct("tim-tim-stripe-dress/");
		productPage.ClickOn_AddToWishList();
		
		WishListPage wishListPage = new WishListPage(driver);
		wishListPage.NavigateToWishList();
		WebElement addToCart =  wishListPage.GetItems().get(0).findElement(By.cssSelector(".add_to_cart_button"));
		addToCart.click();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.NavigateToCart();
		
		Assert.assertTrue(!cartPage.GetItems().isEmpty(),"Item not moved to Cart");	

		WebDriverFactory.QuitDriver();
	}

}
