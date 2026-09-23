package TestAutomationFramework.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetails extends CommonUtil 
{
	WebDriver driver;
	
	
	public ProductDetails(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement loader;
	
	By productBy= By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductlist()
	{
		waitForElementToBeVisible(productBy);
		return products;
	}
	public WebElement getProductbByName(String productName)
	{
		WebElement prod = getProductlist().stream().filter(product ->product.findElement(By.cssSelector("b"))
		.getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addproductToCart(String productName)
	{
		WebElement prod= getProductbByName( productName);
		prod.findElement(addToCart).click();
		waitForElementToBeVisible(toastMessage);
		waitForElementToBeInvisible(loader);
	}	
	

	
}
