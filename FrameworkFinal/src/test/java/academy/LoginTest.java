package academy;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.dataDriven;

public class LoginTest extends Base{

	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		
	
	}
	
	
@Test(dataProvider="getData")

	public void basePageNavigation(String username,String pass,String text) throws InterruptedException {
			
			 LandingPage page=new LandingPage(driver);
			 driver.get(prop.getProperty("url"));
			 	
				page.getLogin().click();
				
				LoginPage lp=new LoginPage(driver);
				
				lp.getEmail().sendKeys(username);
				lp.getPass().sendKeys(pass);
				log.info(text);
				lp.clickLogin().click();
		
		
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		//row stands for how many diffrnt data types test should run
		//col stands for how many values per each test
		
		int size=2;
		int parameter=3;
		int row=size; //no.of TCs
		int col=parameter;//no.of parameter
		Object[][] data=new Object[row][col];
	ArrayList<String> list=new ArrayList();
	dataDriven d=new dataDriven();
		
			
			for(int i=1;i<row+1;i++) {
				list=d.getData(i);
				for(int j=0;j<col;j++) {

					data[i-1][j]=list.get(j+1);
					
				}
				
			}
			
		return data;
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	
}
