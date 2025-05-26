package FrameworkPractice.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkPractice.AbstractComponents.AbstractComponents;
import net.bytebuddy.implementation.bind.annotation.Super;

public class ProductCatalogue extends AbstractComponents{
	
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	    PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsby = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".btn.w-10.rounded");
	By toastMessage = By.id("toast-container");
	By animating = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList()
	{
		waitforElementToAppear(productsby);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException
	{
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addtocart).click();
		waitforElementToAppear(toastMessage);
		waitforElementToDisappear(animating);
		
	}
	
	

	

	

}
