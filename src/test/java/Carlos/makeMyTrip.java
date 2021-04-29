package Carlos;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTrip {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void from() throws InterruptedException {
		WebElement from = driver.findElement(By.id("fromCity"));
		from.click();
		from.sendKeys("BKK");

		Thread.sleep(3000);

		List<WebElement> oneElement = driver.findElements(By.xpath("//*[@id='react-autowhatever-1']/div/ul/li"));

		for (WebElement element : oneElement) {
			String elementText = element.getText();
			System.out.println("---" + elementText + "---");
			if (elementText.contains("BKK")) {
				element.click();
			}
		}

	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
