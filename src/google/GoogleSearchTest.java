package google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());

		
		WebElement searchBar = driver.findElement(By.name("q"));
		//searchBar.sendKeys(new String[] {"Rotten Tomatoes API"});
		searchBar.sendKeys("Rotten Tomatoes API");
		searchBar.submit();
		
		
		driver.close();
	}

}
