package EntrustEnergy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class login extends EntrustEnergy.OpenBrowser  {
	
	@Test
	public static void logIn() throws Exception{
	
		driver.findElement(By.xpath(".//*[@id='login-email']")).sendKeys("softway_admin");
		driver.findElement(By.xpath(".//*[@id='login-password']")).sendKeys("softway.123456");
		driver.findElement(By.xpath(".//*[@id='form-login']/div[4]/div/button")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, "AIM Administrator :: Control Center");
		System.out.println("This is the comit line");
		System.out.println("this is raaes");
		System.out.println("Second line from Raees");
		System.out.println("3rd line from Raees");
		
	}
	
}
