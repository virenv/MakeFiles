package factories;

import java.io.IOException;

import dataProvider.FileConfigReader;

public class ConfigReaderFactory {

	private static FileConfigReader configReader;
	
	public static FileConfigReader GetConfigReader() throws IOException{
		if(configReader==null){
		configReader = new FileConfigReader();
		}
		return configReader;
	}
	 
}

