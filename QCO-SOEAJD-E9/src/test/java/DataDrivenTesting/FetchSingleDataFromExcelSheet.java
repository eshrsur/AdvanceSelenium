package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchSingleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		//Step1: Path Connection of the physical File
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		
		// Step2: Keep Excel File in Read Mode
		Workbook book = WorkbookFactory.create(fis);
		
		//Step3: Getting control on the Sheet
		Sheet sheet = book.getSheet("Sheet1");
		//Sheet sheet = book.getSheet("Sheet1");
		
		//Step4: Getting control on the row
		Row row = sheet.getRow(0);
		
		//Step5: Getting control on the cell
		Cell cell = row.getCell(0);
		
		String ExcelData = cell.getStringCellValue();
		System.out.println(ExcelData);
				

	}

}
