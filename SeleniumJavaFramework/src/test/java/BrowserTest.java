import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		WebElement textBox = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
		
		textBox.sendKeys("Automation Step by Step");
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	}
}
