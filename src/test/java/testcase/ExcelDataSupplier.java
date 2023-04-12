package testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelDataSupplier {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File excelFile = new File(".\\src\\test\\resources\\testdata\\PimsPunchlistExport (5).xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("PimsPunchlistExport");
		System.out.println(sheetName.getPhysicalNumberOfRows());
		
		wb.close();
		fis.close();
		
	}}

		/*int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);

			}
		}
		

	}

*/


	


