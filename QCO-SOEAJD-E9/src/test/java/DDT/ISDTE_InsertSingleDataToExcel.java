package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ISDTE_InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
		//step1:- path connections
		FileInputStream fis = new FileInputStream("./src/test/resources/new.xlsx");
		
		//step2:-open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:-get the control of the Sheet
		Sheet sheet = book.getSheet("Sheet3");
		
		//step4:-get the control of the row
		Row row = sheet.createRow(3);
		
		//step5:-get the control of the cell
		Cell cell = row.createCell(6);
		
		//step6:- insert /create value
		cell.setCellValue("BYE");
		
		//step7:- keep work book in write mode
		FileOutputStream fos = new FileOutputStream("./src/test/resources/new.xlsx");
		book.write(fos);
		book.close();

	}

}
