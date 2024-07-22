package Campaigns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CreateCampaignsWithProduct {


		public static void main(String[] args) throws Throwable {
			
			WebDriver driver=new ChromeDriver();
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
				FileInputStream fis1 = new FileInputStream("C:\\Users\\Surtush\\Downloads\\Book1.xlsx");

				        //step2:- keep Excel_File in Read mode
				         Workbook book1 = WorkbookFactory.create(fis1);
					
				         //step3:- get control of the sheet
				         Sheet sheet1 = book1.getSheet("Product");
				         
				         //step4:- get control of the Row
				         Row row1 = sheet1.getRow(0);
				         
				         //step5:- get control of the Cell
				         Cell cell1 = row1.getCell(0);
				         
				         String prdData = cell1.getStringCellValue()+ranNum;
		        driver.findElement(By.name("productname")).sendKeys(prdData);
		        
		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			
			//Step1:- Path Connection of the physical File
			FileInputStream fis = new FileInputStream("C:\\Users\\Surtush\\Downloads\\Book1.xlsx");

			        //step2:- keep Excel_File in Read mode
			         Workbook book = WorkbookFactory.create(fis);
				
			         //step3:- get control of the sheet
			         Sheet sheet = book.getSheet("Campaigns");
			         
			         //step4:- get control of the Row
			         Row row = sheet.getRow(0);
			         
			         //step5:- get control of the Cell
			         Cell cell = row.getCell(0);
			         
			         String campData = cell.getStringCellValue()+ranNum;
			         
			 driver.findElement(By.name("campaignname")).sendKeys(campData);
//Thread.sleep(5000);
		    driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		    Set<String> wins = driver.getWindowHandles();
		    Iterator<String> it = wins.iterator();
			 while(it.hasNext())
		    {
		    	String win = it.next();
		    	driver.switchTo().window(win);
		    	String currentTitle = driver.getTitle();
		    if(currentTitle.contains("Products&action"))
		    {
		    	break;
		    }
		    }
			
		    driver.findElement(By.name("search_text")).sendKeys(prdData);
		    driver.findElement(By.name("search")).click();
		    
		  //  driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
		    
		    driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
		
		}

	}

//Thank You
	 