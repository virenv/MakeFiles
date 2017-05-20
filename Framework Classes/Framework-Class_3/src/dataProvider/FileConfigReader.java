package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileConfigReader {
	
	private Properties propertyFile;
	private String propertyFilePath= "config/Configurations.properties";

	public FileConfigReader() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
		propertyFile = new Properties();
		propertyFile.load(reader);
		reader.close();
	}

	public String GetBrowserType() {
		String browserName = propertyFile.getProperty("browserType");
		return browserName;
	}
}
