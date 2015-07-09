package EntrustEnergy;
 
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddNewPartner extends login {
	
	
	
	//Test for  going to the add new partner form and then clicking back 
	@Test(priority=1,enabled=true)
	public void newPartner() throws Exception{
		//System.out.println("This runned");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//below code will click on Administrator in the side bar 
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[2]/a")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//Below code will click on the Manage partner 
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[2]/ul/li[2]/a")).click();
		//Below code will click to the add partner button 
		driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/a")).click();
		
		
	}
	
	
	@Test(dependsOnMethods={"newPartner"}, enabled=false) // test for clicking back without entering any data 
	public void clickBack() throws Exception{
		driver.findElement(By.xpath(".//*[@id='page-content']/div/div/a")).click();
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult,"http://aimstaging.entrustenergy.com/standard/users/vendors_index");
	}
	
	@Test(dependsOnMethods={"newPartner"}, enabled=false) // This method will fill the form 
	public void jaddPartnerForm() throws Exception{
		this.newPartner();// Before filling the form have to call addparnerform 
		driver.findElement(By.xpath(".//*[@id='UserVendorName']")).sendKeys("Pratyush");
		driver.findElement(By.xpath(".//*[@id='UserVendorCode']")).sendKeys("1234");
		Select Partner_Type =new Select(driver.findElement(By.xpath(".//*[@id='UserRoleId']")));
		Partner_Type.selectByVisibleText("Web");
		driver.findElement(By.xpath(".//*[@id='UserPhone']")).sendKeys("0123456789");
		driver.findElement(By.xpath(".//*[@id='UserEmail']")).sendKeys("praty@yopmail.com");
		Select Title = new Select(driver.findElement(By.xpath(".//*[@id='UsersContact0Title']")));
		Title.selectByValue("mr");
		driver.findElement(By.xpath(".//*[@id='UsersContact0Name']")).sendKeys("JAi");
		driver.findElement(By.xpath(".//*[@id='UsersContact0Phone']")).sendKeys("0123456789");
		driver.findElement(By.xpath(".//*[@id='UsersContact0Email']")).sendKeys("praty@yopmail.com");
		/*driver.findElement(By.xpath(".//*[@id='UsersContact1Title']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact1Name']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact1Phone']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact1Email']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact2Title']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact2Name']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact2Phone']")).sendKeys("");
		driver.findElement(By.xpath(".//*[@id='UsersContact2Email']")).sendKeys("");*/
		driver.findElement(By.xpath(".//*[@id='UserAddress1']")).sendKeys("Softway Solutions");
		driver.findElement(By.xpath(".//*[@id='UserAddress2']")).sendKeys("Kalyannagar");
		driver.findElement(By.xpath(".//*[@id='UserCity']")).sendKeys("Houston");
		Select state = new Select(driver.findElement(By.xpath(".//*[@id='UserStateId']")));
		state.selectByIndex(43);
		driver.findElement(By.xpath(".//*[@id='UserZipcode']")).sendKeys("015222");
		driver.findElement(By.xpath(".//*[@id='contract_st_date']")).sendKeys("03/02/2015");
		driver.findElement(By.name("data[User][contract_renw_date]")).sendKeys("04/03/2015");
		driver.findElement(By.name("data[User][contract_end_date]")).sendKeys("06/04/2015");
		driver.findElement(By.xpath(".//*[@id='UserUsername']")).sendKeys("pratyush");
		driver.findElement(By.xpath(".//*[@id='UserPassword']")).sendKeys("123456");
		driver.findElement(By.xpath(".//*[@id='UserConfirmPassword']")).sendKeys("123456");
		Select Status = new Select(driver.findElement(By.xpath(".//*[@id='UserStatus']")));
		Status.selectByValue("active");
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='UserVendorsAddForm']/div[4]/div/div/input")).click();
		Thread.sleep(20000);
/*		String errorMessage = driver.findElement(By.xpath(".//*[@id='UserVendorsAddForm']/div[2]/div[15]/div/div")) ;
		Assert.assertEquals("Error. Please try again.", errorMessage);*/
	}
	
}
