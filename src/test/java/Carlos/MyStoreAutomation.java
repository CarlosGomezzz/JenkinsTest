package Carlos;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyStoreAutomation {

	WebDriver driver;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Testcase1() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		String title = "My Store";
		String expectedTitle = driver.getTitle();

		if (title.equals(expectedTitle)) {
			System.out.println("Title is a match");
		} else {
			System.out.println("This is the wrong title");
		}

		WebElement searchbox = driver.findElement(By.xpath("//input[contains (@id, 'search_query_top')]"));
		searchbox.sendKeys("shirt");

		WebElement submmitbutton = driver.findElement(By.xpath("//button[contains (@name, 'submit_search')]"));
		submmitbutton.click();

		Thread.sleep(5000);

		WebElement searchResult = driver.findElement(By.xpath("//span[contains (text(), 'shirt')]"));
		String text = searchResult.getText();

		String expectedSearchResult = "\"SHIRT\"";

		assertEquals(text, expectedSearchResult);
	}

	@After
	public void end() {
		driver.close();
	}
}