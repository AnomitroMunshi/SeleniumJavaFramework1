package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="a[href*='sign_in']")
	WebElement signin;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement title;
	
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']")
	WebElement navbar;
	
	
	public WebElement getLogin() {
		return signin;
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getnavbar() {
		return navbar;
	}
	
	

}
