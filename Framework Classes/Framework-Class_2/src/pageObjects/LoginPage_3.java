package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractClasses.BasePageObject;

/*
 * Extending page objects from a base page class is
 * very common. The main reason is that we can have
 * common functionality inside the base class and
 * specialized functions be in the derived classes.
 * This class show an example of this here.
 */

public class LoginPage_3 extends BasePageObject {

	@FindBy(how = How.CSS, using = "#username")
	private WebElement UserName;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement Password;

	/*
	 * In page object models, when we use an element
	 * that is when Page object model tries to look up for
	 * the actual element in the HTML page. If the element is
	 * not found then NoSuchElement exception is thrown.
	 * 
	 * The point here is that for every call to action on a
	 * WebElement makes POM make a call to the webpage.
	 * This causes a performance hit. If you want to not hit
	 * the Web page every time and instead cache the element, then
	 * we can use the @CacheLookup.
	 * 
	 */
	@CacheLookup()
	@FindBy(how = How.CSS, using = ".button[value='Login']")
	private WebElement Login;

	public LoginPage_3(WebDriver driver) {
		super(driver);
	}

	public void Enter_UserName(String userName) {
		UserName.sendKeys(userName);
	}

	public void Enter_Password(String password) {
		Password.sendKeys(password);
	}

	public void Submit_Login() {
		Login.click();
	}

	public void SignIn(String userName, String password) {
		Enter_UserName(userName);
		Enter_Password(password);
		Submit_Login();
	}

}
