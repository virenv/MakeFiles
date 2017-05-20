package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	private static WebDriver driver = null;

	public static WebDriver GetDriver(String browserType) {
		
		if(driver != null) return driver;

		if(browserType.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserType.equals("Firefox"))
		{
			driver = new FirefoxDriver();

		}
		else if(browserType.equals("InternetExplorer"))
		{
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public static void QuitDriver()
	{
		driver.close();
		driver.quit();		
	}
}
