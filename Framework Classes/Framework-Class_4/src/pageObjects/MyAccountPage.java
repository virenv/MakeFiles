package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

public class MyAccountPage extends BasePageObject {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = ".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--dashboard")
	 public WebElement DashBoard;
	 
	 public Boolean IsDisplayed_Dashboard(){
		 return DashBoard.isDisplayed();
	 }
	 
	 
}
