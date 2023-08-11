import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jkjkl {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		
		
		//Selecting a particular date		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Ran");	
		Thread.sleep(4000);
		
		List<WebElement> options=driver.findElements(By.cssSelector("div[class='calc60'] p"));
		
		for(WebElement option : options)
		{
			//Thread.sleep(3000);
			if(option.getText().equalsIgnoreCase("Ranchi"))
			{
				option.click();
				break;
			}
		}
		
	}
	
}