package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class IDTEUM_InsetDataToExcelUsing_Map {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/new.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet5");
		
		//LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		//map.put("10", "hyd");
		//map.put("20", "Banglore");
		//map.put("30", "Goa");
		//map.put("40", "Pune");
		
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(10,"Shobha");
		map.put(20, "Lily");
		map.put(30, "Harsh");
		map.put(50, "deepak");
		
		int rowNo=0;
		for(Entry<Integer, String> m:map.entrySet())
		{
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue((Integer)m.getKey());
			row.createCell(1).setCellValue((String)m.getValue());
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/new.xlsx");
		book.write(fos);
		book.close();
		
		

	}

}
