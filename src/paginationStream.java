import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class paginationStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//create List price
		List <String> price;
		
		//do while for pagination
		do
		{
			List <WebElement> elementList =driver.findElements(By.xpath("//tr/td[1]"));
			//Filter out rice and create a price list
			price=elementList.stream().filter(s->s.getText().contains("Rice"))
			.map(s->getPriceVegges(s)).collect(Collectors.toList());
			
			price.forEach(a->System.out.println(a));
			
			//through if do pagination that if above code get the required text than exit do while loop
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		

	}
	//creating specific method
	private static String getPriceVegges(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
		
	}

}
