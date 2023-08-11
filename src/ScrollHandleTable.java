import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class ScrollHandleTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++)
		{
			//Integer.parseInt will convert string into integer
			//System.out.println(Integer.parseInt(values.get(i).getText()));
			sum=sum+Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println("sums done by automation : "+sum);
		int total=Integer.parseInt(driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1].trim());
		System.out.println("Total sum extracted from webpage total : "+total);
		Assert.assertEquals(sum, total);
		
		List<WebElement> values1=driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr/td[3]"));
		int sum1=0;
		for(int i=0;i<values1.size();i++)
		{
			//Integer.parseInt will convert string into integer
			//System.out.println(Integer.parseInt(values.get(i).getText()));
			sum1=sum1+Integer.parseInt(values1.get(i).getText());
			
			
		}
		System.out.println("sums done by automation in table 1 : "+sum1);
		
	}

}
