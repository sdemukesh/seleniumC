import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandelingAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String text = "Rahul";
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("input[id=\"alertbtn\"]")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("input[id=\"confirmbtn\"]")).click();
		driver.switchTo().alert().dismiss();
		
		

	} 

}
