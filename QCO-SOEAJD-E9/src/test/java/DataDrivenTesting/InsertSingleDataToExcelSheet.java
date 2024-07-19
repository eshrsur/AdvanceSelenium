package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Step1: Path Connection of the physical File
				FileInputStream fis = new FileInputStream("C:\\Users\\Surtush\\OneDrive\\Documents\\ExcelData.xlsx");
				
				// Step2: Keep Excel File in Read Mode
				Workbook book = WorkbookFactory.create(fis);
				
				//Step3: Get control of the Sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				//Step4: Set row Number
				Row row = sheet.createRow(3);
				
				//Step4: Set cell Number
				Cell cell = row.createCell(3);
				
				//Step4: Set cell value
				cell.setCellValue("Bluetooth");
				
				//Step4: Excel sheet in a write mode
				FileOutputStream fos = new FileOutputStream("C:\\Users\\Surtush\\OneDrive\\Documents\\ExcelData.xlsx");
				book.write(fos);
				book.close();

	}

}
