package TestAutomationFramework.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import TestAutomationFramework.SeleniumFramework.CartPage;
import TestAutomationFramework.SeleniumFramework.ConfirmationPage;
import TestAutomationFramework.SeleniumFramework.FinalCheckout;
import TestAutomationFramework.SeleniumFramework.Login;
import TestAutomationFramework.SeleniumFramework.ProductDetails;
import TestAutomationFramework.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions extends BaseTest {
	public Login loginpage;
	public ProductDetails productDetails;
	public CartPage checkout;
	public ConfirmationPage confirmPage;
	
@Given ("I landed on Ecommerce page")
public void I_landed_on_Ecommerce_page() throws IOException
{
loginpage=lauchApplication();
}

@Given ("^Login with username(.+)and password (.+)$")
public void login_with_username_and_password(String username,String password)
{
	productDetails=loginPage.loginMethod(username,password);	
} 

@When ("^I add product (.+) to cart$")
public void I_add_product_to_cart(String productName) 
{
	productDetails.getProductlist();
	productDetails.addproductToCart(productName);
}

@When ("^checkout (.+) and submit the order$")
public void checkout_and_submit_the_order(String productName)
{
checkout=productDetails.gotoCart();
Boolean match=checkout.verifyCartProduct(productName);
Assert.assertTrue(match);
FinalCheckout finalchkout=checkout.checkoutProduct();
finalchkout.getcheckout("India");
confirmPage=finalchkout.submitOrder();

}
@Then ("{string} message is displayed on ConfirmationPage")
public void message_displayed_on_ConfirmationPage(String message) {

String confirmMsg=confirmPage.getConfirmationMessage();
Assert.assertEquals(confirmMsg, message);	
driver.close();
}
@Then ("{string} message is displayed on LoginPage")

public void message_displayed_on_LoginPage(String message) {

	Assert.assertEquals(loginPage.getErrorMessage(),"Incorrect email or password.");
	driver.close();
}


}
