package org.salesForceTestng;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataBook {
	public static String[][] testData(String excelFileName) throws Exception {
		
		XSSFWorkbook book=new XSSFWorkbook("./TestData/"+excelFileName+".xlsx");
		
		XSSFSheet sheet = book.getSheetAt(0);
	int rowCount = sheet.getLastRowNum();
	System.out.println("ROWS " +rowCount);
	 
	short colunmCount = sheet.getRow(0).getLastCellNum();
	System.out.println("COLUMN "+colunmCount);

		String [][] data = new String [rowCount][colunmCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < colunmCount; j++) {
				XSSFCell eachColumn = eachRow.getCell(j);
				String stringCellValue = eachColumn.getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j] = stringCellValue;
			}
		
		
	}
	book.close();
	return data;

	}

}
