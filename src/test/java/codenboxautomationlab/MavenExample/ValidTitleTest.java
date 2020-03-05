package codenboxautomationlab.MavenExample;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidTitleTest extends Base {
	
	@Test
	public void pageTitle() throws IOException {
		
		driver=initializeDrvier();
		driver.get(prop.getProperty("url"));
		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "Automation Practice");	
	}
	
	@AfterMethod 
	
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}

}
