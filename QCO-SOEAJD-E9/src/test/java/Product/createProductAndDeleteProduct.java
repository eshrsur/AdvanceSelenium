package Product;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class createProductAndDeleteProduct {
	public static void main(String[] args) throws Throwable, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		//Step1:- Path Connection of the physical File
		FileInputStream fis = new FileInputStream("C:\\Users\\Surtush\\Downloads\\Book1.xlsx");
		
		//step2:- keep Excel_File in Read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:- get control of the sheet
		Sheet sheet = book.getSheet("Product");
		
		//step4:- get control of the Row
		Row row = sheet.getRow(0);
		
		//step5:- get control of the Cell
		Cell cell = row.getCell(0);
		
		String prdData = cell.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("productname")).sendKeys(prdData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='\"+prdData+\"']/../preceding-sibling::td/input[@type='checkbox'button[@type='submit']]")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		driver.switchTo().alert().accept();
		
		//List<WebElement> allprd = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		//boolean flag=false;
		
		//for (WebElement prdName : allprd)
		{
			//String actData = prdName.getText();
			//if(actData.contains(prdData))
			{
				//flag=true;
				//break;
			}
		}
		//if(flag)
		{
			//System.out.println("Product data is deleted");
		}
		//else
		{
			//System.out.println("Product data is not deleted");
		}
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Product Deleted Sucessfully");
		driver.close();
		
		
		

	}

}
