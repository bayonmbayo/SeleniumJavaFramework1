package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static String projectPath;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		getRowCount();
		getCellDataNumber(1,1);
	}
	
	public static int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getColCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public static String getCellDataString(int rownum, int columnnum) {
		String celldata = null;
		try {			
			celldata = sheet.getRow(rownum).getCell(columnnum).getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return celldata;
	}
	
	public static void getCellDataNumber(int rownum, int columnnum) {
		try {
			double celldata = sheet.getRow(rownum).getCell(columnnum).getNumericCellValue();
			System.out.println(celldata);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
