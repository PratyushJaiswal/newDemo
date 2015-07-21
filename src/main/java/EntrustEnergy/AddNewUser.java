package EntrustEnergy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class AddNewUser extends login{
	
	
	@Test(priority=1)
	public void navigateToCreateUser() throws Exception{
		
		System.out.println("this is test");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[2]/a")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.enable-tooltip.Add-New-Customer-button")).click();
		String heading = driver.findElement(By.xpath(".//*[@id='page-content']/div/h3")).getText();
		Assert.assertEquals(heading, "Add New EE Administrator");
	}
	
	@Test(dependsOnMethods={"navigateToCreateUser"}, dataProvider = "datafilling")
	public void createUser(String FirstName,String LastName, String AdministratorType, String Phone, String Email, String Address1, String	Address2, String City, String State, String	Zipcode, String	Username, String Password, String ConfirmPassword, String Status, String TestType, String ExpectedResult, String ActualResult, String projStatus 
) throws Exception{
		Thread.sleep(8000);
		//System.out.println("entered in the method name createuser");
		//System.out.println(FirstName);
		driver.findElement(By.xpath(".//*[@id='UserFirstName']")).sendKeys(FirstName);
		driver.findElement(By.xpath(".//*[@id='UserLastName']")).sendKeys(LastName);
		System.out.println(AdministratorType);
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='UserRoleId']")));
		dropdown.selectByValue(AdministratorType);
		driver.findElement(By.xpath(".//*[@id='UserPhone']")).sendKeys(Phone);
		driver.findElement(By.xpath(".//*[@id='UserEmail']")).sendKeys(Email);
		driver.findElement(By.xpath(".//*[@id='UserAddress1']")).sendKeys(Address1);
		driver.findElement(By.xpath(".//*[@id='UserAddress1']")).sendKeys(Address2);
		driver.findElement(By.xpath(".//*[@id='UserCity']")).sendKeys(City);
		Select dropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='UserStateId']")));
		dropdown1.selectByValue(State);
		driver.findElement(By.xpath(".//*[@id='UserZipcode']")).sendKeys(Zipcode);
		driver.findElement(By.xpath(".//*[@id='UserUsername']")).sendKeys(Username);
		driver.findElement(By.xpath(".//*[@id='UserPassword']")).sendKeys(Password);
		driver.findElement(By.xpath(".//*[@id='UserConfirmPassword']")).sendKeys(ConfirmPassword);
		Select dropdown2 = new Select(driver.findElement(By.xpath(".//*[@id='UserStatus']")));
		dropdown2.selectByVisibleText(Status);
		driver.findElement(By.xpath(".//*[@id='UserEeAdminAddForm']/div[4]/div/div/input")).click();
		System.out.println(TestType);
		boolean result = (TestType =="Positive");
		System.out.println(result);
		if(TestType.equalsIgnoreCase("Positive")) 
		{
			String message = driver.findElement(By.cssSelector("#authMessage")).getText();
			System.out.println(message);
			if (message == ExpectedResult )
			{
			driver.findElement(By.cssSelector(".btn.btn-sm.btn-default.enable-tooltip.Add-New-Customer-button")).click();
			}
			else 
			{
				driver.navigate().refresh(); 
				driver.switchTo().alert().sendKeys("Resend");
				Thread.sleep(10000);
				Assert.fail("There is bug as positive data is submitted ");
				
			}
			
		}
		else if(TestType.equalsIgnoreCase("Negative"))
		{
			driver.navigate().refresh(); 
			driver.switchTo().alert().accept();
		}
		else 
		{
			System.out.println("This code should not run");
		}
	}
	
	@DataProvider
	public Object[][] datafilling () throws Exception{
		String path = System.getProperty("user.dir") + "//src//test//resources//UserDataField.xlsx";
		Object[][] testObjArray = ExcelUtils.getTableArray(path,"Sheet1");
		System.out.println(path);
		return (testObjArray);
	}

}
