package FrameworkPractice.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkPractice.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents{

	WebDriver driver;
	public cartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	public Boolean cartProductValidation(String ProductName)
	{
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
        
	}

}
