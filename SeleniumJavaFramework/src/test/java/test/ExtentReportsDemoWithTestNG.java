package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() {
		 	test = extent.createTest("Google Search Test One", "this a test for google search functionality");
            
	        test.log(Status.INFO, "Starting Test Case");
	        driver.get("https://www.google.com");
	        test.pass("Navigated to google.com");
	        
	        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
	        test.pass("Entered text in searchbox");
	        
	        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	        test.pass("Pressed keyboard enter key");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
        driver.quit();
        test.pass("Closed the browser");
        test.info("Test Completed");
	}
	
	@AfterSuite
	public void tearDown() {     
        extent.flush();
	}
}
