package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop = new Properties();
	
	public WebDriver initializaDriver() throws IOException{

		
		FileInputStream fils = new FileInputStream("/Users/techsupporttx/Movies/eclipse-workspace/xendit-qa-assessment/src/main/java/resources/data.properties");		
		prop.load(fils);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "//Users//techsupporttx//Movies//eclipse-workspace//chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
