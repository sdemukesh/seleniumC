import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBrokenUrl {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		//broken links
		// getAttribute will give all url's 
		// Java method will call url and will get you the status code
		// a[href*='soapui']		//a[href*='brokenlink']
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		//String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href"); //status 200
		
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href"); //status 404
		
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		
		
	}

}
