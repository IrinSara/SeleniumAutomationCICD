package TestAutomationFramework.SeleniumFramework;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Orders extends CommonUtil 
{


	WebDriver driver;
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> myorders;
	
	
	
	
	public Orders(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	
	public Boolean verifyProductinOrderHistory(String productName)
	{
		gotoOrders();
		Boolean match=myorders.stream().anyMatch(cartproduct->cartproduct.getText().trim().equalsIgnoreCase(productName));	
		return match;
	}
	
	
	
}
