package rahulshettyacademy.resources;
 import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//extent report maven
public class ExtentReportNG {
	
	public static ExtentReports getReportObject () {
		String path = System.getProperty("user.dir") +"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Autom`ation Result"); //report name
		reporter.config().setDocumentTitle("Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name","Sulochana");
		return extent;
	}

}
