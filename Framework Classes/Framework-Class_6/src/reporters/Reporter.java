package reporters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.Utils;

public class Reporter {
	private static ExtentReports extentReports;
	private static ExtentTest report; 
	
	private Reporter() {	}
	
	public static ExtentReports InitiateReporter(String reportPath){
		if(extentReports == null){
			extentReports = new ExtentReports(reportPath + Utils.GetTimeStamp() + ".html");
			extentReports.addSystemInfo("Host Name", "ToolsQA");
			extentReports.addSystemInfo("Environment", "QA");
			extentReports.addSystemInfo("User Name", "Lakshay Sharma");
		}
		return extentReports;
	}
	
	public static ExtentTest StartTest(String testName){
		return report = extentReports.startTest(testName);
	}
	
	public static ExtentTest GetReporter(){
		return report;
	}
	
	public static void EndTest(){
		extentReports.endTest(report);
	}
	
	public static void CloseReport(){
		extentReports.flush();
		extentReports.close();		
	}
	
}
