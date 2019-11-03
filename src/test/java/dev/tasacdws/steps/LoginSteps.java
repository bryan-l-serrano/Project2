package dev.tasacdws.steps;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.tasacdws.pages.Homepage;
import dev.tasacdws.runners.WebsiteRunner;
import junit.framework.Assert;

public class LoginSteps {
	
	public static WebDriver driver = WebsiteRunner.driver;
	public static Homepage homepage = WebsiteRunner.homepage;
	
	@Given("^The user is on the website homepage$")
	public void the_user_is_on_the_website_homepage() throws Throwable{
		driver.get("localhost:4200/loginpage");
	}
	
	@When("^The user puts in their information and clicks login$")
	public void the_user_puts_in_their_information_and_clicks_login() throws Throwable{
		
		homepage.nameField.sendKeys("bdog");
		homepage.password.sendKeys("password");
		homepage.loginButton.click();
	}
	
	@Then("^The user should be on the user page$")
	public void the_user_should_be_on_the_user_page() throws Throwable{
		Assert.assertEquals("localhost:4200/useroptionspage", driver.getCurrentUrl());
	}
}