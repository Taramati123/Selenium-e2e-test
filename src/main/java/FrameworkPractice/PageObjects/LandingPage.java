package FrameworkPractice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkPractice.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement  userEmailid;
	
	@FindBy(id="userPassword")
	WebElement  userPasswordid;
	
	@FindBy(id="login")
	WebElement  loginbutton;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement  errormessage;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmailid.sendKeys(email);
		userPasswordid.sendKeys(password);
		loginbutton.click();
		return new ProductCatalogue(driver);
		
	}
	
	public String getErrormessage()
	{
		waitforWebElementToAppear(errormessage);
		return errormessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	

	

}
