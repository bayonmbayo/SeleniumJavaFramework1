package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		
		googleSearch();
		
	}
	
	public static void googleSearch() throws InterruptedException {
		
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");;
		
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);	
		GoogleSearchPage.button_search(driver).click();
		
		Thread.sleep(5000);
		driver.close();
		
		System.out.println("Test completed successfully");
				
	}
}
