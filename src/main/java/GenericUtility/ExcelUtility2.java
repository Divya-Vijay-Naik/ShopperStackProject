package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility2 {

	String filepath="C:\\Users\\User\\eclipse-workspace\\restAssuredProject\\src\\test\\resources\\resources\\ExcelUtility.xlsx";
	
	public String getDataFromExcel(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream=new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fileInputStream);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		wb.close();
		return data;
		
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
        FileInputStream fis = new FileInputStream(filepath);
        Workbook wb = WorkbookFactory.create(fis);
        int rowCount = wb.getSheet(sheetName).getLastRowNum();
        wb.close();
        return rowCount;
    }

}
