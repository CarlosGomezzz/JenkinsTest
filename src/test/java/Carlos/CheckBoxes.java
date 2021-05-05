package Carlos;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Testcase1() throws InterruptedException {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("(//input[contains(@type, 'checkbox')])[1]")));

		Boolean checkbox1 = driver.findElement(By.xpath("(//input[contains(@type, 'checkbox')])[1]")).isSelected();
		Boolean checkbox2 = driver.findElement(By.xpath("(//input[contains(@type, 'checkbox')])[2]")).isSelected();

		System.out.println("Checkbox 1 is by default unchecked");
		Assert.assertFalse(checkbox1);
		System.out.println("Checkbox 2 by default is checked");
		Assert.assertTrue(checkbox2);

		driver.findElement(By.xpath("(//input[contains(@type, 'checkbox')])[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@type, 'checkbox')])[1]")).click();

		Thread.sleep(3000);
	}

	@AfterMethod
	public void end() {
		driver.close();
	}

}
