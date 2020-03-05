package codenboxautomationlab.MavenExample;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class NavigationBarTest extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDrvier();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigationBar() {
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
	}
	
	@Test
	public void dropDownSelect() {
		LandingPage l=new LandingPage(driver);
		Select s=new Select (l.getDropDown());
		s.selectByValue("option1");
		Assert.assertTrue(l.getDropDown().isDisplayed());
		
	}
	
 @AfterTest 
	
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}
	

}
