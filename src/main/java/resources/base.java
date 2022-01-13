package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	
	public static WebDriver driver = null;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException
	{
		prop=intProperty();
		String browserName =prop.getProperty("browser");
		//String browserName = System.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			//1-Allow, 2-Block, 0-default
			options.setExperimentalOption("prefs",prefs);
			driver = new ChromeDriver(options);
		
		}
		else if(browserName=="firefox")
		{
			
		}
		else if(browserName=="internetExplorer")
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public Properties intProperty() throws IOException
	{
        prop = new Properties();
	    
		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(Fis);
		return prop;
	}
	
}
