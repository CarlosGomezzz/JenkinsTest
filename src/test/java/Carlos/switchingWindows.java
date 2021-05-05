package Carlos;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchingWindows {
	WebDriver driver;
	Actions action;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[1]/div/a"))
				.click();
		Thread.sleep(2000);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWindow = it.next();
		String childWindow1 = it.next();
		String childWindow2 = it.next();
		String childWindow3 = it.next();
		Thread.sleep(2000);

		driver.switchTo().window(childWindow1);
		System.out.println("Child window 1 = " + driver.getTitle());
		Thread.sleep(2000);

		driver.switchTo().window(childWindow2);
		System.out.println("Child window 2 = " + driver.getTitle());
		Thread.sleep(2000);

		driver.switchTo().window(childWindow3);
		System.out.println("Child window 3 = " + driver.getTitle());
		Thread.sleep(2000);

		driver.switchTo().window(parentWindow);
		System.out.println("Back to parents window = " + driver.getTitle());
		Thread.sleep(2000);
	}
}
