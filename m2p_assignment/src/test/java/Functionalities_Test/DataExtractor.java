package Functionalities_Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataExtractor {
	public Object[][] getdatafromexcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("D:\\Users\\deepa\\eclipse-workspace\\m2p_assignment\\src\\test\\resources\\TestDatam2p.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("userRegistration");
		int lastrowcount = sh.getLastRowNum();
		int lastcellcount=sh.getRow(1).getLastCellNum();
		Object[][] obj=new Object[lastrowcount][lastcellcount];
		
		for(int i=0; i<lastrowcount; i++) {
			for(int j=0; j<lastcellcount; j++) {
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
	}

}
