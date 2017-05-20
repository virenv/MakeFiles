package utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static String GetTestName(String fullTestName){
		String testName = fullTestName.substring(fullTestName.lastIndexOf('.') + 1, fullTestName.length());
		return testName;
	}
	
	public static String GetTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
