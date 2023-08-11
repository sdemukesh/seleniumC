import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calander {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
		
		//Selecting a particular date		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		//driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).sendKeys(Keys.ENTER);
		
		while(!driver.findElement(By.cssSelector("div[class='flatpickr-month']")).getText().contains("Aug"))
		{
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
			//Thread.sleep(1000);
		}
		
		
		//Trying to click on a date
		List<WebElement> dates=driver.findElements(By.className("flatpickr-day"));
		
		int count = driver.findElements(By.className("flatpickr-day")).size();
		
		for(int i=0;i<count;i++)
		{
			String text =driver.findElements(By.className("flatpickr-day")).get(i).getText();
			//Thread.sleep(1000);
			if(text.equalsIgnoreCase("25"))
			{
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}

	}

}
