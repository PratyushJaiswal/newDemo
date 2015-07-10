package EntrustEnergy;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class editFormNormal extends login{
	@Test(priority=1)
	public void openForm() throws Exception{
		String path= ".//*[@id='personalinfo_first_name']";
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[4]/a")).click();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[1]/div/ul[2]/li[4]/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("EnrollmentSearchKey")).sendKeys("1278");
		driver.findElement(By.xpath(".//*[@id='archiveForm']/div[2]/div/div[2]/div/span/button")).click();
		driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div/table/tbody/tr[1]/td[12]/div/a[2]")).click();
		driver.findElement(By.xpath(path)).sendKeys("praty");

	}

}
