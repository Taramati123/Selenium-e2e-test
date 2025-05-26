package FrameworkPractice.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkPractice.PageObjects.CheckoutPage;
import FrameworkPractice.PageObjects.ConfirmationPage;
import FrameworkPractice.PageObjects.LandingPage;
import FrameworkPractice.PageObjects.ProductCatalogue;
import FrameworkPractice.PageObjects.cartPage;
import FrameworkPractice.TestComponents.BaseTest;
import FrameworkPractice.TestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest{

	@Test(groups= {"errorhandling"},retryAnalyzer = Retry.class)
	public void loginErrorvalidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
        landingpage.loginApplication("taramytyt7@gmail.com", "Gavdabhesi123!@");
        //.ng-tns-c4-4.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
        
        Assert.assertEquals("Incorrect email or password.", landingpage.getErrormessage());
        
         
	}
	
	@Test
	public void ProductErrorvalidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		String ProductName="IPHONE 13 PRO";
        ProductCatalogue productcatalogue=landingpage.loginApplication("naiktara1994@gmail.com", "Gavdabhesi123!@");
        
        List<WebElement>products=productcatalogue.getProductList();
        
        productcatalogue.addProductToCart(ProductName);
        
        cartPage cartPage=productcatalogue.goTocartPage();
        
        Boolean match=cartPage.cartProductValidation("IPHONE 13 PRO");
        Assert.assertTrue(match);
      
        
        
        
	}

}
