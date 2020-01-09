package google;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
        String requiredUrl = "https://developer.fandango.com/rotten_tomatoes";

		
		//Open Google
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());

		//Search text
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("Rotten Tomatoes API");
		searchBar.submit();
		
		//Get result 	
        List<WebElement> listOfUrls = driver.findElements(By.xpath("//*[@class='r']//*[@href]"));	
        		
		for (WebElement url: listOfUrls)
		{            
			if (url.getAttribute("href").equals(requiredUrl)) 
			{
				System.out.println("The required link is present on the first page of Google search!");
				break;
			}
			
		}		
		driver.close();
	}

}
