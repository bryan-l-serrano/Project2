package dev.tasacdws.runners;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.tasacdws.pages.Homepage;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="dev.tasacdws.steps")
public class WebsiteRunner {
	
	public static WebDriver driver;
	public static Homepage homepage;
	
	@BeforeClass
	public static void setup() {
		File file = new File("src/main/resources/geckodriver");
		System.setProperty("webriver.firefox.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		homepage = new Homepage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@AfterClass 
	public static void tearDown() {
		driver.quit();
	}

}
