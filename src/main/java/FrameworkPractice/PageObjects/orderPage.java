package FrameworkPractice.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkPractice.AbstractComponents.AbstractComponents;

public class orderPage extends AbstractComponents{

	WebDriver driver;
	public orderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProducts;
	
	public Boolean orderpageValidation(String ProductName)
	{
		Boolean match=orderProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
        
	}

}
