package FrameworkPractice.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import FrameworkPractice.PageObjects.CheckoutPage;
import FrameworkPractice.PageObjects.ConfirmationPage;
import FrameworkPractice.PageObjects.LandingPage;
import FrameworkPractice.PageObjects.ProductCatalogue;
import FrameworkPractice.PageObjects.cartPage;
import FrameworkPractice.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimpli extends BaseTest{
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public  cartPage cartPage;
	public ConfirmationPage ConfirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingpage=launchApplication();
	}
	
	@Given("^Logged in with username(.+) and password(.+)$")
	public void Logged_in_username_and_password(String username, String password)
	{
		productcatalogue=landingpage.loginApplication(username,password);
	}
	
	 @When("^add product(.+) to cart$")
	 public void add_product_to_cart(String productName) throws InterruptedException
	 {
		 List<WebElement>products=productcatalogue.getProductList();
	        
	        productcatalogue.addProductToCart(productName);
	 }
	 
	 @When("^Checkout(.+) and submit the order$")
	 public void checkout_and_submit_the_order(String productName)
	 {
		 cartPage=productcatalogue.goTocartPage();
	        
	        Boolean match=cartPage.cartProductValidation(productName);
	        Assert.assertTrue(match);
	        
	        CheckoutPage CheckoutPage=cartPage.checkout();
	        
	         CheckoutPage.checkout("india");
	         ConfirmationPage=CheckoutPage.submitOrder();
	 }
	 
	 @Then("{string} message is displayed on ConfirmationPage")
	 public void message_is_displayed_on_confirmationpage(String string)
	 {
		 String confirmmessage=ConfirmationPage.getConfirmMessage();
         
	        Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));
	        driver.close();
	 }
	 
	 @Then("{string} message is displayed")
	 public void message_is_displayed(String string)
	 {
		 Assert.assertEquals("Incorrect email or password.", landingpage.getErrormessage());
	        driver.close();
	 }
	

}
