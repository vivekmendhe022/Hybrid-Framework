package com.generic.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains read & write methods of excel file.
 * 
 * @author Vivek M
 *
 */
public class ExcelFileUtility {

	public String readDataFromExcelSheet(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		return book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}

	public void writeDataFromExcelSheet(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();

		FileOutputStream fout = new FileOutputStream(IConstantUtility.EXCELFILEPATH);
		book.write(fout);
		book.close();
	}

	public Object[][] readDataFromExcelSheetUsingDataProvider(String SHEETNAME)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(SHEETNAME);

		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[row][cell];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

	public Object[][] readMultipleDataFromExcelSheet(String SHEETNAME) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(SHEETNAME);

		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[row + 1][cell]; // Consider rows as one-based
		for (int i = 0; i <= row; i++) { // loop should go till i <= row
			for (int j = 0; j < cell; j++) {
				Cell currentCell = sheet.getRow(i + 1).getCell(j); // start from 2nd row as first row usually contains
																	// column names
				if (currentCell.getCellType() == CellType.STRING) {
					data[i][j] = currentCell.getStringCellValue();
				} else if (currentCell.getCellType() == CellType.NUMERIC) {
					data[i][j] = Double.toString(currentCell.getNumericCellValue()); // converting numeric value to
																						// string
				}
			}
		}
		return data;
	}

}
