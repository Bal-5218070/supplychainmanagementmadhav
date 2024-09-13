package com.madhav.geniric.excelutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilty {
public String getDataFromExcelSheet(String sheetname, int rowno,int cellno) throws EncryptedDocumentException, IOException {
	FileInputStream fis =new FileInputStream("./testData/madhavproject.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
 String value = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).toString();
 wb.close();
 return value;
}
}
