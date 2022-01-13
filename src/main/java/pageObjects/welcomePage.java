package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class welcomePage {
	WebDriver driver;
	public Properties prop;
	public welcomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Welcome to Facebook, ')]")
	private WebElement text;
	
	@FindBy(xpath="//a[@aria-label='Home']")
	public WebElement home;
	
	@FindBy(xpath="//span[contains(text(),\"What's on your mind, \")]")
	public WebElement statusText;
	
	@FindBy(xpath="//div[@class='_1mf _1mj']")
	public WebElement typeText;
	
	@FindBy(xpath="//span[text()='Post']")
	public WebElement buttonClick;
	
	public void clickHome()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.textToBePresentInElement(text, "Welcome to Facebook, "));
		Actions a = new Actions(driver);
		a.moveToElement(home).click().perform();
		a.moveToElement(statusText).click().perform();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Create post']"), "Create post"));
		typeText.sendKeys("Hello World");
		buttonClick.click();
	}
	
}
