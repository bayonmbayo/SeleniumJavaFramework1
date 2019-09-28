package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		googleSearchTest();
	}
	
	public static void googleSearchTest() throws InterruptedException {		
		driver = new ChromeDriver();
		GoogleSearchPageObject google = new GoogleSearchPageObject(driver);
		
		driver.get("https://www.google.com");
		
		google.setTextInSearchBox("Automation Step by Step");
		google.clickSearchBox();
		
		Thread.sleep(5000);
		driver.close();
		
		System.out.println("Test completed successfully");
	}
}
