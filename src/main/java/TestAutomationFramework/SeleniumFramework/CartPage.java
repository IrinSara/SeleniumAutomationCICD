package TestAutomationFramework.SeleniumFramework;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends CommonUtil 
{


	WebDriver driver;
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement chkout;
	
	
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	
	public Boolean verifyCartProduct(String productName)
	{
		gotoCart();
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().trim().equalsIgnoreCase(productName));	
		return match;
	}
	
	public FinalCheckout checkoutProduct()
	{
		chkout.click();
		FinalCheckout finalchkout= new FinalCheckout(driver);
		return finalchkout;
	}
}
