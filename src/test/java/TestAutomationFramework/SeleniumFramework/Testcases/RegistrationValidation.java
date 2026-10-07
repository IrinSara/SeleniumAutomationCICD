package TestAutomationFramework.SeleniumFramework.Testcases;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestAutomationFramework.SeleniumFramework.Registration;
import TestAutomationFramework.TestComponents.BaseTest;

public class RegistrationValidation extends BaseTest {

	@Test(groups = {"Registration"})
	public void registrationWithValidData() {
		Registration registration = loginPage.gotoRegistration();
		String email = "selenium-" + UUID.randomUUID() + "@example.com";

		registration.register("Test", "User", email, "1234567890", "Engineer", "Male",
				"ValidPass123!", "ValidPass123!");

		Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.urlContains("/auth/login")),
				"Successful registration should return to the login page");
	}

	@Test(groups = {"Registration"})
	public void registrationWithInvalidData() {
		Registration registration = loginPage.gotoRegistration();

		registration.register("Test", "User", "invalid-email", "1234567890", "Engineer", "Male",
				"ValidPass123!", "ValidPass123!");

		Assert.assertFalse(registration.isEmailValid(),
				"The malformed email should fail form validation");
		Assert.assertTrue(driver.getCurrentUrl().contains("/auth/register"),
				"Invalid registration data should keep the user on the registration page");
	}
}
