package DDT;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RMDFE_ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/new.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet4");
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		
		for (int i=0;i<rowNum;i++)
		{
			Row row = sheet.getRow(rowNum);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				
				DataFormatter format = new DataFormatter();
				String ExcelData= format.formatCellValue(cell);
				System.out.println(ExcelData);
			}
		}

	}

}
