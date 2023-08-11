import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoopingDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String parenWindiwID = driver.getWindowHandle();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int i=0;
		while (i<4)
		{
			driver.findElement(By.id("hrefIncChd")).click();
			i++;
		}
		
		for(int j=1;j<4;j++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult, 4 Child");
		Thread.sleep(3000);
		
		//Open new tab and switch to new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		
		//Open new Window and switch to new Window
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.switchTo().window(parenWindiwID);
		driver.close();
		driver.quit();
		

	}

}
