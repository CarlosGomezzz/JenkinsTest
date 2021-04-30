package Carlos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClassExample {
	WebDriver driver;
	Actions action;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		WebElement darggable = driver.findElement(By.id("draggable"));
		WebElement droppaple = driver.findElement(By.id("droppable"));
		action = new Actions(driver);
		action.dragAndDrop(darggable, droppaple).build().perform();
		;

	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
