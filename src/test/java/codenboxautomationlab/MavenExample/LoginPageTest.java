package codenboxautomationlab.MavenExample;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginPageTest extends Base{
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDrvier();
		driver.get(prop.getProperty("url"));
	}
	
    @Test (dataProvider="getData")	
    public void basePageLogin(String UserNmae, String Password) throws InterruptedException {
    	LandingPage l = new LandingPage(driver);
    	
    	l.getLogin().click(); //Click on login button
    	Thread.sleep(5000L);
    	
    	
    	LoginPage lp=new LoginPage(driver);
    	lp.getEmail().sendKeys(UserNmae);
    	lp.getPassword().sendKeys(Password);
    	lp.getLogin().click();
    }
	
	
	
	
	@DataProvider 
	public Object[][] getData() {
		// Row stands for how many different data types/set test should run
				// Column stands how many different values for each type/set test
				Object[][] data = new Object[1][2];
				// 0th row
				data[0][0] = "test@test.com";
				data[0][1] = "123456";
				
				return data;
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}

}
