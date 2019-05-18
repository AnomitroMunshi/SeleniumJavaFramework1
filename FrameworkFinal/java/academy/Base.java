package academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;


public class Base {

	
	public static WebDriver driver;
	public Properties prop;
	public String projectpath=System.getProperty("user.dir");
	public WebDriver initializeDriver() throws IOException {
		
		
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(projectpath+"\\src\\main\\resources\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}else if(browserName=="firefox") {
			//for FireFox
		}else {
			//for I
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	 public void getScreenshot(String result) throws IOException {
		 
		 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("F:\\Selenium\\Screenshot\\"+result+" screenshot.png"));
		
	 }
	
}
