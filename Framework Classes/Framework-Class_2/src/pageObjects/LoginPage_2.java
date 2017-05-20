package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/*
Change the description for Sign function
 */
public class LoginPage_2 {

	@FindBy(how = How.CSS, using = "#username")
	private WebElement UserName;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement Password;

	@FindBy(how = How.CSS, using = ".button[value='Login']")
	private WebElement Login;

	public LoginPage_2(WebDriver driver) {
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

	public void SignIn(String userName, String password) {
		Enter_UserName(userName);
		Enter_Password(password);
		Submit_Login();
	}
}
