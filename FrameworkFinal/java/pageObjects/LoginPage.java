 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='user_email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement submit;
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPass() {
		return password;
	}
	
	public WebElement clickLogin() {
		return submit;
	}

}
