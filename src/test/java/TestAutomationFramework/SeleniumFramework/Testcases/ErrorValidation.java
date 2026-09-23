package TestAutomationFramework.SeleniumFramework.Testcases;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import TestAutomationFramework.SeleniumFramework.CartPage;
import TestAutomationFramework.SeleniumFramework.ProductDetails;
import TestAutomationFramework.TestComponents.BaseTest;
import TestAutomationFramework.TestComponents.Retry;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		loginPage.loginMethod("anshika@gmail.com", "Iam000");
		Assert.assertEquals(loginPage.getErrorMessage(),"Incorrect email or password." );

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		ProductDetails productCatalogue = loginPage.loginMethod("rahulshetty@gmail.com", "Iamking@000");
		productCatalogue.getProductlist();
		productCatalogue.addproductToCart(productName);
		CartPage cartPage = productCatalogue.gotoCart();
		Boolean match = cartPage.verifyCartProduct("ZARA COAT 33");
		Assert.assertFalse(match);
	
	}

	
	

}
