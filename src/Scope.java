import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		
	//1. Give me count of links on the page
	//2. count of link in footer section
	//3. Count of links in 1as column of footer
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size()); //scope here is entire page
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));		//limiting scope 
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size()); //gives count in footer
		
		WebElement columndriver=footerDriver.findElement(By.xpath("//table[@class=\"gf-t\"]/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//Open each link in a new tab and get title of each tag of 1st column
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) 
		{
			String clickonlink =Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Thread.sleep(3000);
		}
			Set<String> abc=driver.getWindowHandles();
			Iterator <String> It=abc.iterator();
	//Using while loop to loop through each opened tab and grap the title		
			while(It.hasNext())
			{
				driver.switchTo().window(It.next());
				System.out.println(driver.getTitle());
			}
		
		
		

	}

}
