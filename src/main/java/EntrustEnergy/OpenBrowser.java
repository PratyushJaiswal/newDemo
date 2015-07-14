// This class will be used to open the browser and close the 

package EntrustEnergy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class OpenBrowser {
	// Declared the function as public static so that other classes can use same driver name to invoke the webdriver instance publicly
	public static WebDriver driver = new FirefoxDriver();
	
	//@before annotations Describes this method has to run before the all suite 
	@BeforeSuite
	public void openSite() throws Exception { //There are chances that below code can generate some exception to handle that used throws
		driver.manage().window().maximize(); 	// Codes make sure that the browser is always in maximized 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //This code will wait for the 15 seconds for opening the get Url 
		driver.get("http://aimstaging.entrustenergy.com/standard");
	}
	 //@AfterSuite notation if we want some code to run after the test cases are executed 
	@AfterSuite
	public void closeBrowser() throws Exception { 
		driver.quit();
	}
	@AfterClass
	public static void logout() throws Exception{
		driver.findElement(By.cssSelector(".sidebar-nav>li>a")).click();
	}

}
