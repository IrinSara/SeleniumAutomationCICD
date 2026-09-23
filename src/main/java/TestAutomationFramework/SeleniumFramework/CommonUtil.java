package TestAutomationFramework.SeleniumFramework;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil 
{
			
	WebDriver driver;
	public CommonUtil(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cart;
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orders;
	public CartPage gotoCart()
	{
		cart.click();
		CartPage checkout=new CartPage(driver);
		return checkout;
	}
	public Orders gotoOrders()
	{
		orders.click();
		Orders od=new Orders(driver);
		return od;
	}
	public void waitForElementToBeVisible(By findBy)
	{	
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToBeVisible(WebElement ele)
	{	
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForElementToBeInvisible(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
		
	
	
}
