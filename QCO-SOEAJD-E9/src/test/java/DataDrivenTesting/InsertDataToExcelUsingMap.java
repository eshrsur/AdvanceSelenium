package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {

public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/new.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet2");
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("10", "Surabhi");
		map.put("20", "Tushar");
		map.put("30", "Tiya");
		map.put("40", "Ramesh");
		map.put("50", "Rita");
		map.put("60", "Reshma");
		map.put("70", "Kajal");
		
		int rowNo=0;
		for (Entry<String, String> m : map.entrySet())
		{
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue((String)m.getKey());
			row.createCell(1).setCellValue((String)m.getValue());
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/new.xlsx");
		book.write(fos);
		book.close();
		
				
		
		
		

	}

}
