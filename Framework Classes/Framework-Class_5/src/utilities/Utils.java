package utilities;

public class Utils {

	public static String GetTestName(String fullTestName){
		String testName = fullTestName.substring(fullTestName.lastIndexOf('.') + 1, fullTestName.length());
		return testName;
	}
}
