package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	static String excelPath = System.getProperty("user.dir");
	static String sheet = "Sheet1";
	static WebDriver driver;
	
	@BeforeTest
	public void setUpTest() {		
		driver = new ChromeDriver();
		
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username + " | " + password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		Object[][] data = testData(excelPath + "/excel/data.xlsx", sheet);
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int columnCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][columnCount];
		
		
		for(int i=1; i < rowCount; i++) {
			for(int j = 0; j < columnCount; j++) {
				String celldata = excel.getCellDataString(i, j);
				//System.out.print(celldata + " | ");
				data[i-1][j] = celldata;
			}
			System.out.println();
		}
		
		return data;
	}
}
