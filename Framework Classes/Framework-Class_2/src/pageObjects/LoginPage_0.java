package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/*
 * This is a simple page object of Login page.
 * Here we are simply creating a class which has
 * public members. Each member is a webelement and part 
 * of the Login page. By creating a class we are abstracting
 * out the Login page in one class. There by increasing code
 * reuse and making the code maintainable.
 */
public class LoginPage_0 {

	@FindBy(how = How.CSS, using = "#username")
	public WebElement UserName;

	@FindBy(how = How.CSS, using = "#password")
	public WebElement Password;

	@FindBy(how = How.CSS, using = ".button[value='Login']")
	public WebElement Login;

	public LoginPage_0(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
