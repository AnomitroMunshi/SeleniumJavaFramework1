package academy;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.dataDriven;

public class ValidateNavbar extends Base{

	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	
	}
	
	@Test
	public void validateNavBarTest()  {
	
		
			 LandingPage page=new LandingPage(driver);
			
			
			 Assert.assertTrue(page.getnavbar().isDisplayed());
			 log.info("Successfully validated NavBar");	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
		
		
		
}
	
	
