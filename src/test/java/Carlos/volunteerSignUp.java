package Carlos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class volunteerSignUp {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		// info
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-1')]")).sendKeys("Los");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-2')]")).sendKeys("Gomez");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-3')]")).sendKeys("5555555555");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-4')]")).sendKeys("USA");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-5')]")).sendKeys("Arlington");
		driver.findElement(By.xpath("//input[contains(@id, 'RESULT_TextField-6')]")).sendKeys("test@gmail.com");

		// gender
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_RadioButton-7_0')]")).click();

		// days to volunteer
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_CheckBox-8_6')]")).click();
		driver.findElement(By.xpath("//label[contains(@for, 'RESULT_CheckBox-8_0')]")).click();

		// best time to call
		driver.findElement(By.xpath("//select[contains(@id, 'RESULT_RadioButton-9')]")).click();
		driver.findElement(By.xpath("//option[contains(@value, 'Radio-0')]")).click();

		// submit
		driver.findElement(By.xpath("//input[contains(@id, 'FSsubmit')]")).click();

	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
