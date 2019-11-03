package dev.tasacdws.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	public WebElement nameField;
	
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(className = "btn btn-primary")
	public WebElement loginButton;
	
}
