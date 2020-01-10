package google;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.*;


public class GoogleSearchTest {
	
	private String searchEngine;
	private String pageTitle;
	private WebElement searchField;
	private String searchText;
	private String requiredUrl;
	private List<WebElement> urlList;
	
	WebDriver driver = new ChromeDriver();
	
	public GoogleSearchTest(String requiredUrl, String searchEngine) {
		this.searchEngine = searchEngine;
		this.requiredUrl = requiredUrl;
		this.urlList = new ArrayList<WebElement>();
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	public String getSearchText() {
		return this.searchText;
	}
	
	public void setPageTitle(String url) {
		driver.get(url);
		this.pageTitle = driver.getTitle();
	}
	
	public void setSearchField() {
		this.searchField = driver.findElement(By.name("q"));
	}
	
	public void searchText() {
		searchField.sendKeys(getSearchText());
		searchField.submit();
	}
	
	public List<String> findResults() {
		List<String> urlStringList = new ArrayList<>();
		this.urlList = this.driver.findElements(By.xpath("//*[@class='r']//*[@href]"));
		
		for (WebElement url : urlList) {
			urlStringList.add(url.getAttribute("href"));
		}
		return urlStringList;
	}
	
	public void getFinalResult() {
		List<String> urlStringList = findResults();
		MatcherAssert.assertThat(urlStringList, hasItems(requiredUrl));
	}
	
	public void close() {
		driver.close();
	}
}
