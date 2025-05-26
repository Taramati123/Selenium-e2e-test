package FrameworkPractice.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkPractice.PageObjects.CheckoutPage;
import FrameworkPractice.PageObjects.ConfirmationPage;
import FrameworkPractice.PageObjects.LandingPage;
import FrameworkPractice.PageObjects.ProductCatalogue;
import FrameworkPractice.PageObjects.cartPage;
import FrameworkPractice.PageObjects.orderPage;
import FrameworkPractice.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 extends BaseTest{
	String ProductName="IPHONE 13 PRO";
	
	@Test(dataProvider = "getData",groups = {"purchase"})
	public void StandAloneTest2(HashMap<String, String> input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
        ProductCatalogue productcatalogue=landingpage.loginApplication(input.get("email"), input.get("password"));
        
        List<WebElement>products=productcatalogue.getProductList();
        
        productcatalogue.addProductToCart(input.get("ProductName"));
        
        cartPage cartPage=productcatalogue.goTocartPage();
        
        Boolean match=cartPage.cartProductValidation(input.get("ProductName"));
        Assert.assertTrue(match);
        
        CheckoutPage CheckoutPage=cartPage.checkout();
        
         CheckoutPage.checkout("india");
         ConfirmationPage ConfirmationPage=CheckoutPage.submitOrder();
         String confirmmessage=ConfirmationPage.getConfirmMessage();
         
        Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        }
	
	@Test(dependsOnMethods = {"StandAloneTest2"})
	public void orderhistory()
	{
		ProductCatalogue productcatalogue=landingpage.loginApplication("taramatirmn@gmail.com", "Gavdabhesi123!@");
		orderPage orderPage=productcatalogue.goToorderPage();
		orderPage.orderpageValidation(ProductName);
	
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		/*HashMap<String, String> map= new HashMap<String,String>();
		map.put("email", "taramatirmn@gmail.com");
		map.put("password", "Gavdabhesi123!@");
		map.put("ProductName", "ZARA COAT 3");
		
		HashMap<String, String> map1= new HashMap<String,String>();
		map1.put("email", "naiktara1994@gmail.com");
		map1.put("password", "Gavdabhesi123!@");
		map1.put("ProductName", "ADIDAS ORIGINAL");*/
		
		List<HashMap<String,String>> data= getJasonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\FrameworkPractice\\Data\\PurchaseOrder.jason");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	
	
	
	//@DataProvider
	//public Object[][] getData()
	//{
		//return new Object[][] {{"taramatirmn@gmail.com","Gavdabhesi123!@","ZARA COAT 3"},{"naiktara1994@gmail.com","Gavdabhesi123!@","ADIDAS ORIGINAL"}};
	//}

}
