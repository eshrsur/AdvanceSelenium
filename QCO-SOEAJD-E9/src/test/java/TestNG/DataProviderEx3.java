package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProviderEx3 {
	
	@Test(dataProvider = "getData")
	public void bookTickets(String orgName,String phno,String email) throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phno);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		Random ranNum = new Random();
		int ranNumber = ranNum.nextInt(1000);
		
		objArr[0][0]="Surabhi"+ranNumber;
		objArr[0][1]="8588960237";
		objArr[0][2]="surabhidipa113@gmail.com";
		
		objArr[1][0]="Tushar"+ranNumber;
		objArr[1][1]="7903409720";
		objArr[1][2]="tushar.kr0412@gmail.com";
		
		objArr[2][0]="Bulbul"+ranNumber;
		objArr[2][1]="7903408734";
		objArr[2][2]="bulbul@gmail.com";
				
		return objArr;
		
	}

}
