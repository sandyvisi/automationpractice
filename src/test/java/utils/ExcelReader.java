package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	 
	static String excelPath=System.getProperty("user.dir")+"\\automationexercise\\src\\test\\resources\\automationpracticeproject.xlsx";
	
	public static Object[][] excelDatas(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(excelPath);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet(sheetName);

		int rowSize = sheet.getPhysicalNumberOfRows();

		Row rows = sheet.getRow(0);

		int colSize = rows.getPhysicalNumberOfCells();

		Object[][] datas = new Object[rowSize - 1][colSize];

		DataFormatter df = new DataFormatter();

		for (int a = 1; a < rowSize; a++) {

			Row rws = sheet.getRow(a);

			for (int b = 0; b < colSize; b++) {

				Cell cellvalue = rws.getCell(b);

				String values = df.formatCellValue(cellvalue);
				datas[a - 1][b] = values;
			}

		}

		return datas;

	}

}
