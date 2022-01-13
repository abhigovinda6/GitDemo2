package Automation.assignment1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.welcomePage;
import resources.base;

public class HomePage extends base {

	WebDriver driver;
	@BeforeTest
	public void getIntializeDriver() throws IOException
	{
		driver=intializeDriver();
		
	}
	
	@Test
	public void homePageTest() throws IOException {
		driver.get(prop.getProperty("url"));
		homePage h= new homePage(driver);
		h.enterUserName();
		h.enterPassword();
		welcomePage w =h.login();
		w.clickHome();
		
		
	}
	

}
