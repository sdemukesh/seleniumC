import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UsingStreamInAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Wedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture text of all Webelements into list
		List <WebElement> elementList=driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture text of all webelements into new(original) list
		List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sort in the list of step 3 -> sorted list
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//System.out.println( sortedList+ " :"+originalList);
		List <String> price=elementList.stream().filter(s->s.getText().contains("Beans"))
		.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
