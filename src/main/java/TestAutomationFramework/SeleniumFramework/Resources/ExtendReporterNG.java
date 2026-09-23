package TestAutomationFramework.SeleniumFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

	public static ExtentReports getReportsObject()
	{
		String path=System.getProperty("user.dir")+"//report//TestReport";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation RepoterTutorial");
		reporter.config().setDocumentTitle("Intermodal QA");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Irin Mathew");
		extent.setSystemInfo("Environment", "QA");
		return extent;
	}
}
