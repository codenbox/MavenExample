package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	By navbar=By.xpath("//*[@id='primary-menu']"); // Home page header navigation
	By title=By.xpath("//*[@id='post-501']/header/h1"); // title for Automation Practice
	By login=By.xpath("//a[contains(text(),'Log in')]"); //Login Button
	By dropDown=By.xpath("//select[@id='dropdown-class-example']");
	
	public LandingPage(WebDriver x) {
		this.driver=x;
		
	}
	
	
	
	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	

	public WebElement getDropDown() {
		return driver.findElement(dropDown);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
