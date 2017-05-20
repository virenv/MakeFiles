package factories;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		}else{
			new Exception("Browser name passed as " + browserType + " which is not correct");
		}
	
		try {
			driver.manage().timeouts().implicitlyWait(ConfigReaderFactory.GetConfigReader().GetImplicitlyWait(), TimeUnit.SECONDS);
		} catch (IOException e) {			
			new Exception("Implicit Wait is not correct"); 
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver GetDriver() {
		return driver;
	}
	
	public static void QuitDriver()
	{
		driver.close();
		driver.quit();		
	}
	
	public static String CaptureScreenShot(String testName) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/" + ConfigReaderFactory.GetConfigReader().GetScreenShotPath() + testName + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
}
