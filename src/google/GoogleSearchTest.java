package google;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		//Open Google
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());

		//Search text
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("Rotten Tomatoes API");
		searchBar.submit();
		
		//Get result 	
		List<WebElement> websitesLinks = driver.findElements(By.xpath("//cite"));
		
		List<String> values = new ArrayList<String>();
		
		for (WebElement results: websitesLinks)
		{
			values.add(results.getText());
		}

		System.out.println(values);

		//Check URL
		String url = "https://developer.fandango.com › rotten_tomatoes";

		for (String value: values) 
		{

			if (value.trim().contains(url)) {
				System.out.println("URL is present on the first page");
			}
		}
		
		
		
		driver.close();
	}

}
