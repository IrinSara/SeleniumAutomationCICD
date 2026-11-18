package TestAutomationFramework.SeleniumFramework.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

	public static ExtentReports getReportsObject()
	{
		Path reportPath=Paths.get(System.getProperty("user.dir"), "Test-artifacts", "extent", "ExtentReport.html");
		try {
			Files.createDirectories(reportPath.getParent());
		} catch (IOException e) {
			throw new IllegalStateException("Unable to create the Extent report directory", e);
		}
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath.toString());
		reporter.config().setReportName("Web Automation RepoterTutorial");
		reporter.config().setDocumentTitle("Intermodal QA");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Irin Mathew");
		extent.setSystemInfo("Environment", "QA");
		return extent;
	}
}
