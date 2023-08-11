import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MisdcellaneousTopics {

	public static void main(String[] args) throws IOException {

		// using option class to set the behavior of chrome
		
		  ChromeOptions options = new ChromeOptions();
		  options.setAcceptInsecureCerts(true);
		  
		  
		  //Exploring ChromeOption method
		  
		 

		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed(null);
		
		//Take Screenshot
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Screenshots\\screenshot.png"));  //can not give path of C driver will not work

	}

}
