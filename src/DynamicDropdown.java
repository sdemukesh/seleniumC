import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		//driver.findElement(By.xpath("//a[contains(text(),' Bengaluru (BLR)')]")).click();

		// Handle dynamic dropdown with indexing
		
//		driver.findElement(By.xpath("//a[@text=\"Bengaluru (BLR)\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[contains(text(),'Chennai (MAA)')])[2]")).click();
//		
		
		//Handeling dynamic dropdown without indexing
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value=\"BLR\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"MAA\"]")).click();
		
		
	
	}

}
