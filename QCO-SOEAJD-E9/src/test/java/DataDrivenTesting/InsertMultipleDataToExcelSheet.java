package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertMultipleDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Step1: Path Connection of the physical File
		FileInputStream fis = new FileInputStream("C:\\Users\\Surtush\\OneDrive\\Documents\\new.xlsx");
		
		// Step2: Keep Excel File in Read Mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step3: Get control of the Sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(int i = 0; i< allLinks.size(); i++)
		{
			 Row row=sheet.createRow(i);
			 Cell cell = row.createCell(0);
			 cell.setCellValue(allLinks.get(i).getAttribute("href"));
			 System.out.println(allLinks.get(i).getAttribute("href"));
		}
			 
			 FileOutputStream fos = new FileOutputStream("C:\\Users\\Surtush\\OneDrive\\Documents\\new.xlsx");
			 book.write(fos);
			 book.close();
			 

	}

}
