import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMultipleItemToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Orange"};
		
		
		Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0; i<products.size();i++)
		{
			
			//Actual name we are getting :Brocoli - 1 Kg
			// splitting on "-" we get Brocoli and 1 Kg
			
		String[] name =products.get(i).getText().split("-");	
		String formatedName =name[0].trim();
		
		//we converted it to array as split gives 2 string at 2 indexed
		//Format it to get actual item name
		//Check wether name you extracted is present in array or not
		//Convert array into array list
		
		List itemsNeededList = Arrays.asList(itemsNeeded);
		
		if(itemsNeededList.contains(formatedName))
		{
			j++;
			driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
			//break;	//Can not use break as this execution will stop as soon as first item is selected
			// so we can not use break when we iterate through a list and selecting more than on item
			if(j==3)
			{
				break;
			}
				
			
		}
		}

	}

}
