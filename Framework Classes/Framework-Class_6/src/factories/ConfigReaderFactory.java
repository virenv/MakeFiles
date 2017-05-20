package factories;

import java.io.IOException;
import dataProvider.ExcelTestDataReader;
import dataProvider.FileConfigReader;

public class ConfigReaderFactory {

	private static FileConfigReader configReader;
	private static ExcelTestDataReader testDataReader;
	
	public static FileConfigReader GetConfigReader() throws IOException{
		if(configReader==null){
			configReader = new FileConfigReader();
		}
		return configReader;
	}
	 
	public static ExcelTestDataReader GetTestDataReader() throws IOException{
		if(testDataReader==null){
			testDataReader = new ExcelTestDataReader(configReader.GetTestDataFilePath());
		}
		return testDataReader;
	}	
}

