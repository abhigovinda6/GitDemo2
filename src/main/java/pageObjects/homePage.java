package pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class homePage extends base{
	
	WebDriver driver;
	public Properties prop;
	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input#email")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='pass']")
	public WebElement password;
	
	@FindBy(xpath="//button[text()='Log In']")
	public WebElement login;
	
	public void enterUserName() throws IOException
	{
		prop=intProperty();
		userName.clear();
		userName.sendKeys(prop.getProperty("username"));
	}
	
	public void enterPassword() throws IOException
	{
		prop=intProperty();
		password.clear();
		password.sendKeys(prop.getProperty("password"));
	}
	
	public welcomePage login() {
		login.click();
		welcomePage w = new welcomePage(driver);
		return w;
	}

}
