package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportBasicDemo {
	
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "this a test to validate google search functionnalities");
        
        driver = new ChromeDriver();
               
        // log(Status, details)
        test1.log(Status.INFO, "Starting Test Case");
        driver.get("https://www.google.com");
        test1.pass("Navigated to google.com");
        
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
        test1.pass("Entered text in searchbox");
        
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        test1.pass("Pressed keyboard enter key");
        
         
        driver.close();
        driver.quit();
        test1.pass("Closed the browser");
        
        test1.info("Test Completed");
        
        ExtentTest test2 = extent.createTest("Google Search Test Two", "this a test to validate google search functionnalities");
        
        driver = new ChromeDriver();
               
        // log(Status, details)
        test2.log(Status.INFO, "Starting Test Case");
        driver.get("https://www.google.com");
        test2.pass("Navigated to google.com");
        
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
        test2.pass("Entered text in searchbox");
        
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        test2.fail("Pressed keyboard enter key");
        
         
        driver.close();
        driver.quit();
        test2.pass("Closed the browser");
        
        test2.info("Test Completed");
        
        extent.flush();
		
	}
}
