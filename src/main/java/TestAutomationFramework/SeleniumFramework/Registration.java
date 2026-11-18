package TestAutomationFramework.SeleniumFramework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration extends CommonUtil {
	WebDriver driver;

	public Registration(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userMobile")
	WebElement userMobile;

	@FindBy(id = "occupation")
	WebElement occupation;

	@FindBy(css = "input[name='gender'][value='Male']")
	WebElement maleGender;

	@FindBy(css = "input[name='gender'][value='Female']")
	WebElement femaleGender;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(css = "input[type='checkbox']")
	WebElement ageConfirmation;

	@FindBy(css = "button[type='submit']")
	WebElement registerButton;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement errorMsg;

	public void register(String firstNameValue, String lastNameValue, String email, String mobile,
			String occupationValue, String gender, String passwordValue, String confirmPasswordValue) {
		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastNameValue);
		userEmail.sendKeys(email);

		userMobile.sendKeys(mobile);
		new Select(occupation).selectByVisibleText(occupationValue);

		if ("Male".equalsIgnoreCase(gender)) {
			maleGender.click();
		} else if ("Female".equalsIgnoreCase(gender)) {
			femaleGender.click();
		} else {
			throw new IllegalArgumentException("Gender must be Male or Female");
		}

		password.sendKeys(passwordValue);
		confirmPassword.sendKeys(confirmPasswordValue);
		ageConfirmation.click();
		registerButton.click();
		if (getErrorMessage().equalsIgnoreCase("Please enter a valid email address.")) {
			System.out.println("Registration not successful ");
		}
	}

	public String getErrorMessage() {
		waitForWebElementToBeVisible(errorMsg);
		return errorMsg.getText();
	}

	public boolean isEmailValid() {
		Object result = ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].checkValidity();", userEmail);
		return Boolean.TRUE.equals(result);
	}
}
