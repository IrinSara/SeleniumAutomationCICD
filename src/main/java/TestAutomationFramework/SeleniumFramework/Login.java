package TestAutomationFramework.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends CommonUtil
{
	WebDriver driver;
	
	public Login(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//WebElement password=driver.findElement(By.id("userPassword"));
	//WebElement loginbtn=driver.findElement(By.id("login"));
	//Pagefactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;
	@FindBy(xpath="//div[@role='alert']")
	WebElement errorMsg;

	@FindBy(linkText="Register here")
	WebElement registerLink;
	
	public ProductDetails loginMethod(String email,String pwd)
	{
	userEmail.sendKeys(email);	
	password.sendKeys(pwd);
	loginbtn.click();
	ProductDetails productCatalog=new ProductDetails(driver);
	return productCatalog;
	}

	public Registration gotoRegistration()
	{
		registerLink.click();
		return new Registration(driver);
	}
	
	public void openUrl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		waitForWebElementToBeVisible(errorMsg);
		return errorMsg.getText();
	}

}
