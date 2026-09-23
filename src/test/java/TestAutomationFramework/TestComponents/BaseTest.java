package TestAutomationFramework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestAutomationFramework.SeleniumFramework.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
public WebDriver driver;
public Login loginPage;

	//method for initializing driver
	public WebDriver initializeDriver() throws IOException
	{
	Properties prop=new Properties();
	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestAutomationFramework\\SeleniumFramework\\Resources\\GlobalData.properties");
	FileInputStream fis=new FileInputStream("D:\\Irin\\TestAutomation\\SeleniumFramework\\src\\main\\java\\TestAutomationFramework\\SeleniumFramework\\Resources\\GlobalData.properties");
	prop.load(fis);
	String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		}
	else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	}
	
	//method get jason mapping to hashmap
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	}
	
	//method for taking screenshot
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public Login lauchApplication() throws IOException
	{
		driver=initializeDriver();
		loginPage=new Login(driver);
		loginPage.openUrl();
		return loginPage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
}
