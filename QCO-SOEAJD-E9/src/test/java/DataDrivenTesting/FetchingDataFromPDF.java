package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/doc_85D9BG.pdf");
	    PDDocument doc = PDDocument.load(file);
	    int pages = doc.getNumberOfPages();
	    //System.out.println(pages);
	    
	     PDFTextStripper pdfdata = new PDFTextStripper();
	     //String data = pdfdata.getText(doc);
	     //System.out.println(data);
	     
	     pdfdata.setStartPage(1);
	     String pagedata = pdfdata.getText(doc);
	     System.out.println(pagedata);
	     
	     pdfdata.setStartPage(1);
	     pdfdata.setEndPage(3);
	    String pageDatas = pdfdata.getText(doc);
	    System.out.println(pageDatas);
	

	}

}
