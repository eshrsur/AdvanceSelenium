package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WMDTE_WriteMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/new.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet4");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(int i=0; i<allLinks.size();i++)
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/new.xlsx");
		book.write(fos);
		book.close();
		

	}

}
