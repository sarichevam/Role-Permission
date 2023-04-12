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
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import utilities.ReadXLSdata;

public class anotherWayToHandlePopUp extends BaseClass {
	@Test(priority = 1)
	public void LoginTest() throws InterruptedException {

		driver.findElement(By.name("user_id")).sendKeys("msaricheva@engsoftsolutions.com");// locators properties
		Thread.sleep(4000);
		driver.findElement(By.id("user_password")).sendKeys("pims2021");
		Thread.sleep(4000);
		driver.findElement(By.id("EnterButton")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[normalize-space()='ESS LLC - PIMS.NET QA']")).click();
		Thread.sleep(4000);
		String at = driver.getTitle();
		String no = "PIMS";
		// System.out.println(at);
		if (at.equalsIgnoreCase(no)) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Failure");

		}
		// Assert.assertTrue(false);
	}

	
	public class newOne {

		public void main(String[] args) throws EncryptedDocumentException, IOException {
			ReadXLSdata red = new ReadXLSdata();
			red.getData("PimsPunchlistExport");

		}

		public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
			File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheetName = wb.getSheet(excelSheetName);

			int totalRows = sheetName.getLastRowNum();
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
			return testData;

		}
	}
}
