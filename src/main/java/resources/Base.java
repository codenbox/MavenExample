package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	//Method to initialize driver
	public WebDriver initializeDrvier() throws IOException {
		
		 prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\Sarif\\MavenExample\\src\\main\\java\\resources\\data.properties");
		prop.load(fs);
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SeleniumWork\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\SeleniumWork\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();	
			
		} else if (browserName.equalsIgnoreCase("IE")) { // execute in IE

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);	
		
		return driver;
		
	}
	
	public void getScreenshot(String result) throws IOException {
		// Web Driver take the screenshot as a file and save in virtually in src
		// variable.
		//File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// copy the file from src and put in your local machine with the name of failed
		// test class
		FileUtils.copyFile(srcFile, new File("C://screenshotTest//" + result + "screenshot.png"));

	}
	

}
