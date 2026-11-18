package TestAutomationFramework.SeleniumFramework.Testcases;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestAutomationFramework.SeleniumFramework.CartPage;
import TestAutomationFramework.SeleniumFramework.ConfirmationPage;
import TestAutomationFramework.SeleniumFramework.FinalCheckout;
import TestAutomationFramework.SeleniumFramework.Orders;
import TestAutomationFramework.SeleniumFramework.ProductDetails;
import TestAutomationFramework.TestComponents.BaseTest;


public class EndtoEndTestCase extends BaseTest
{
	//String username="testemail2026@outlook.com";
	//String password="T3ster@.";
	//String productName="ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException
	{
	
	ProductDetails productDetails=loginPage.loginMethod(input.get("email"), input.get("password"));
	productDetails.getProductlist();
	productDetails.addproductToCart(input.get("productName"));
	
	CartPage checkout=productDetails.gotoCart();
	Boolean match=checkout.verifyCartProduct(input.get("productName"));
	Assert.assertTrue(match);
	
	FinalCheckout finalchkout=checkout.checkoutProduct();
	finalchkout.getcheckout("India");
	ConfirmationPage confirmPage=finalchkout.submitOrder();
	String confirmMsg=confirmPage.getConfirmationMessage();
	Assert.assertEquals(confirmMsg, "THANKYOU FOR THE ORDER.");
	}
	
	
	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData")
	public void verifyOrdersHistory(HashMap<String,String>input) throws IOException
	{
	
	ProductDetails productDetails=loginPage.loginMethod(input.get("email"), input.get("password"));
	Orders orders=productDetails.gotoOrders();
	Boolean match=orders.verifyProductinOrderHistory(input.get("productName"));
	Assert.assertTrue(match);
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
	
		List<HashMap<String,String>> data=getJsonDataToMap(Paths.get(System.getProperty("user.dir"), "src", "test", "java", "TestAutomationFramework", "TestData", "PurchaseOrder.json").toString());
		return  new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	//@DataProvider
	//public Object[][] getData()
	//{
		//return new Object[][] {{"testemail2026@outlook.com","T3ster@.","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		
		
	//}
	/*@DataProvider
		public Object[][] getData()
		{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email","testemail2026@outlook.com");
		map.put("password","T3ster@.");
		map.put("productName","ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email","Wine2026@outlook.com");
		map1.put("password","Wine@2026");
		map1.put("productName","ADIDAS ORIGINAL");
		return  new Object[][] {{map},{map1}};
			
			
		}*/
	
	
}