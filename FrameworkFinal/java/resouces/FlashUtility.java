package resouces;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlashUtility {
	
	//BlinkHighlight an element
	public static void blinkHighlight(WebElement element,WebDriver driver) {
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgColor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);//1
			changeColor(bgColor, element, driver);//2
			
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		try {
			Thread.sleep(20);
		}
		catch(Exception e) {
			
		}
	}
	
	
	//Border around Element
	public static void drawBorder(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	
	//Generate custom alert
	public static void generateAlert(String message,WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	
	//Click element by JS
	public static void clickElementbyJS(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	//Refersh via JS
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	//Scroll page down via JS
		public static void scrollPageDown(WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}

	//Scroll into view JS
		public static void scrollintoView(WebElement target,WebDriver driver) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",target);
		}	
		
		
}
