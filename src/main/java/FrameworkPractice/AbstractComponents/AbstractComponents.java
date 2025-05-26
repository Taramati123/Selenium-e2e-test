package FrameworkPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkPractice.PageObjects.CheckoutPage;
import FrameworkPractice.PageObjects.cartPage;
import FrameworkPractice.PageObjects.orderPage;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public void waitforElementToAppear(By findby)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	       
	}
	
	public void waitforWebElementToAppear(WebElement findby)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(findby));
	       
	}
	
	public void waitforElementToDisappear(By findby) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findby)));
	}
	
	public cartPage goTocartPage()
	{
		cart.click();
		return new cartPage(driver);
	}
	
	public orderPage goToorderPage()
	{
		orders.click();
		return new orderPage(driver);
	}
	
	public CheckoutPage checkout()
	{
		checkout.click();
		return new CheckoutPage(driver);
	}

}
