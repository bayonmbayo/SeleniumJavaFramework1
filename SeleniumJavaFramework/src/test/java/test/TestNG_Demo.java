package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.GoogleSearchPage;

public class TestNG_Demo {
	
	public static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		driver = new ChromeDriver();
	}

	@Test
	public static void googleSearch() {
			
		driver.get("https://www.google.com");
		
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");;
		
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);	
		GoogleSearchPage.button_search(driver).click();
		
		
				
	}
	
	@AfterTest
	public void tearDownTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Test completed successfully");
	}
}
