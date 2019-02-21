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

public class Validatetitle extends Base{
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		log.info("Driver Initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to Homepage");
	}

	@Test
	public void validateTitleTest()  {
	
		 LandingPage page=new LandingPage(driver);
		 Assert.assertEquals(page.getTitle().getText(), "FEATURED COURSE");
		 log.info("Successfully validated Text message");	
	}
		
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver CLosed");
		driver=null;
	}
		
}
	
	
