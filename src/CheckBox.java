import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		Thread.sleep(3000);
		//To get count of all checkboxes we used findElements and .size()
		System.out.println(driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());
		
		//Assertion using TestNG
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='StudentDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='StudentDiscount']")).isSelected());
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
		

	}

}
