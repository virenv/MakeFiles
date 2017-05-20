package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/*
 *  This page object demonstrates how a we can completely
 *  abstract out the internal details of page object model.
 *  Once we have abstracted out the details of the Pageobject
 *  We can expose the POm via service methods. For e.g. in the 
 *  case of Login page model we can have functions like
 *  - Login
 *  - EnterUserName
 *  - EnterPassword
 */
public class LoginPage_1 {

	@FindBy(how = How.CSS, using = "#username")
	private WebElement UserName;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement Password;

	@FindBy(how = How.CSS, using = ".button[value='Login']")
	private WebElement Login;

	public LoginPage_1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Enter_UserName(String userName) {
		UserName.sendKeys(userName);
	}

	public void Enter_Password(String password) {
		Password.sendKeys(password);
	}

	public void Submit_Login(){
		Login.click();
	}

}
