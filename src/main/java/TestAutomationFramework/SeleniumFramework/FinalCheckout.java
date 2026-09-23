package TestAutomationFramework.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCheckout extends CommonUtil {

	public FinalCheckout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy(css=".action__submit")
	WebElement submit;

	@FindBy(xpath="//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement countryoption;
	
	By results= By.cssSelector(".ta-results");
	
	public void getcheckout(String country)
	{
		
		Actions a= new Actions(driver);
		a.sendKeys(selectCountry,country).build().perform();
		waitForElementToBeVisible(results);
		countryoption.click();
		
	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		
		return 	new ConfirmationPage(driver);
	}
	
}
