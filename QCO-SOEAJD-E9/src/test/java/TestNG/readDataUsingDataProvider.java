package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataUsingDataProvider {

	@Test(dataProvider = "readDataUsingDataProvider")
	
	//public void bookTickets(String orgName,String phno,String email) throws Throwable
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
	
		
	
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/new.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <lastRow ; i++)
		{
			for (int j = 0; j < lastCell; j++) 
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
		
	}
	

}
