package Carlos;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MortgageAutomation {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mortgagecalculator.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Testcase1() throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@id, 'homeval')]")).sendKeys("500000");
		driver.findElement(By.xpath("//input[contains(@id, 'downpayment')]")).sendKeys("30000");
		driver.findElement(By.xpath("//input[contains(@id, 'loanamt')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id, 'loanamt')]")).sendKeys("470000");
		driver.findElement(By.xpath("//input[contains(@id, 'intrstsrate')]")).sendKeys("2.5");

		driver.findElement(By.xpath("//input[contains(@id, 'loanterm')]")).sendKeys("30");
		driver.findElement(By.xpath("//select[contains(@name, 'param[start_month]')]")).click();
		driver.findElement(By.xpath("//option[contains(@value, '10')]")).click();
		driver.findElement(By.xpath("//input[contains(@id, 'start_year')]")).sendKeys("2022");

		Thread.sleep(5000);
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
