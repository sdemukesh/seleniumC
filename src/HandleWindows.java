import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Open parent and click on link to open child tab/widow
// copy email id from child page by splitting and rimming email from set of strings and 
//copy it in parent window id secton

public class HandleWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> windows=driver.getWindowHandles();	//[parentId, childId]
		Iterator<String> it = windows.iterator();
		String parentId=it.next();
		String childId=it.next();		//it will give childId index
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
		String emailId=driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split(" ")[4];
		
		driver.switchTo().window(parentId);		//switching back to parent window
		driver.findElement(By.id("username")).sendKeys(emailId);
		

	}

}
