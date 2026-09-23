package TestAutomationFramework.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends CommonUtil {

	public ConfirmationPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
public String getConfirmationMessage() {
	return confirmMsg.getText();
}
}
