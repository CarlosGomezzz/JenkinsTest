package Carlos;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MortgageAutomation {

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
		driver.get("https://www.mortgagecalculator.org/");
		driver.findElement(By.xpath("//input[contains(@id, 'homeval')]")).sendKeys("500000");
		driver.findElement(By.xpath("//input[contains(@id, 'downpayment')]")).sendKeys("30000");
		driver.findElement(By.xpath("//input[contains(@id, 'loanamt')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id, 'loanamt')]")).sendKeys("470000");
		driver.findElement(By.xpath("//input[contains(@id, 'intrstsrate')]")).sendKeys("2.5");
		Thread.sleep(5000);
	}

	@After
	public void end() {
		driver.close();
	}
}
