package EntrustEnergy;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Enrollment extends EntrustEnergy.login{
static String reference ="1277" ;
static String verifyResult = "10400511129030001";
	//below test will navigate to the Enrollment page 
	@Test(priority=1)
  public void navigateEnrollment() throws Exception {
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[4]/a")).click();
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[4]/ul/li[1]/a")).click();
	  Thread.sleep(5000);
  }
	//below test will search by reference of enrollment searchkey 
	@Test(priority=2)
	public static void searchByReference() throws Exception{
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.findElement(By.id("EnrollmentSearchKey")).sendKeys(reference);
		driver.findElement(By.xpath(".//*[@id='archiveForm']/div[2]/div/div[2]/div/span/button")).click();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		String Esid = driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div/table/tbody/tr/td[8]")).getText();
		Thread.sleep(8000);
		Assert.assertEquals(verifyResult, Esid);
		Thread.sleep(4000);
		}
	//Below test will click on the view 
	
	@Test(priority=3)
	public void viewEnrollment() throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div/table/tbody/tr[1]/td[12]/div/a[1]")).click();
		Thread.sleep(8000);
		String PassText = driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/h3")).getText();
		Assert.assertEquals("Enrollment", PassText);
		driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='reset']")).click();
		}
	//below test case click on the edit form 
	@Test(priority=4)
	public void editEnrollment() throws Exception{
		reference = "1278";
		verifyResult = "1008901016780365490100";
		Enrollment.searchByReference();		
		String status = driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div/table/tbody/tr[1]/td[4]")).getText();
		System.out.println(status);
		if(status == "Incomplete - I"){
			// driver.findElement(By.id("personalinfo_first_name"));		
		}
		driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div/table/tbody/tr[1]/td[12]/div/a[2]")).click();
		 Thread.sleep(10000);
	}
	// enter the data from the data provider we have to just pass the parameters in the method 
	@Test(dataProvider="data1",priority=5)
	public void editEnrollmentonhold(String FNpath, String FirstName, String LNpath, String LastName, String DDpath, String DD, String MMpath, String MM, String YYpath, String YY, String SSN1, String SSN1key, String SSN2, String SSN2key, String SSN3, String SSN3key, String Phpath1, String num1, String Phpath2, String num2, String Phpath3, String num3, String lanpath, String Billtype, String waivechb, String callDepopath, String callDepoV, String Nosalpath, String nosal, String submit) throws Exception{
		//driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div/table/tbody/tr[1]/td[12]/div/a[2]")).click();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//Thread.sleep(4000);
		driver.findElement(By.xpath(FNpath)).sendKeys(FirstName);
		driver.findElement(By.xpath(LNpath)).sendKeys(LastName);
		Select Day = new Select(driver.findElement(By.xpath(DDpath)));
		Day.selectByVisibleText(DD);
		Select month = new Select(driver.findElement(By.xpath(MMpath)));
		month.selectByVisibleText(MM);
		Select year = new Select(driver.findElement(By.xpath(YYpath)));
		year.selectByVisibleText(YY);
		driver.findElement(By.xpath(SSN1)).sendKeys(SSN1key);
		driver.findElement(By.xpath(SSN2)).sendKeys(SSN2key);
		driver.findElement(By.xpath(SSN3)).sendKeys(SSN3key);
		driver.findElement(By.xpath(Phpath1)).sendKeys(num1);
		driver.findElement(By.xpath(Phpath2)).sendKeys(num2);
		driver.findElement(By.xpath(Phpath3)).sendKeys(num3);
		driver.findElement(By.xpath(lanpath)).click();
		driver.findElement(By.xpath(Billtype)).click();
		driver.findElement(By.xpath(waivechb)).click();
		Select callDepo = new Select(driver.findElement(By.xpath(callDepopath)));
		callDepo.selectByValue(callDepoV);
		Select NoSal = new Select(driver.findElement(By.xpath(Nosalpath)));
		NoSal.selectByValue(nosal);
		driver.findElement(By.xpath(submit)).click();


	}
	//data provider store the data as an 2-d array 
	@DataProvider(name = "data1")
	public Object[][] dataIncompleteStatus(){
		Object [][] data = new Object[1][30]; 
		data[0][0] = ".//*[@id='personalinfo_first_name']";
		data[0][1] = "pratyush";
		data[0][2] = ".//*[@id='personalinfo_last_name']";
		data[0][3] = "Jaiswal";
		data[0][4] = ".//*[@id='dob_mm']";
		data[0][5] = "6";
		data[0][6] = ".//*[@id='dob_dd']";
		data[0][7] = "16";
		data[0][8] = ".//*[@id='dob_yy']";
		data[0][9] = "1988";
		data[0][10] = ".//*[@id='social_security_number1']";
		data[0][11] = "1234";
		data[0][12] = ".//*[@id='social_security_number1']";
		data[0][13] = "56";
		data[0][14] = ".//*[@id='social_security_number1']";
		data[0][15] = "7890";
		data[0][16] = ".//*[@id='phone1']";
		data[0][17] = "879";
		data[0][18] = ".//*[@id='phone2']";
		data[0][19] = "245";
		data[0][20] = ".//*[@id='phone3']";
		data[0][21] = "1234";
		data[0][22] = ".//*[@id='EnrollmentCommunicationLanguageEnglish']";
		data[0][23] = ".//*[@id='EnrollmentBillTypeElectronicEmail']";
		data[0][24] = ".//*[@id='waive_deposit']";
		data[0][25] = ".//*[@id='EnrollmentSalesDisposition']";
     	data[0][26] = "no sale";
		data[0][27] = ".//*[@id='EnrollmentNoSaleReasonId']";
		data[0][28] = "18";

		data[0][29] = ".//*[@id='button1']";
		return data;
	}
}
