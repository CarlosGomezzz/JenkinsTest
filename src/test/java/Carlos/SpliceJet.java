package Carlos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpliceJet {

	WebDriver driver;
	Select s;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void passengers() throws InterruptedException {
		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]"));
		dropdown1.click();
		Thread.sleep(2000);

		WebElement adultDropdown = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Adult\"]"));
		s = new Select(adultDropdown);
		s.selectByValue("5");
		Thread.sleep(2000);

		WebElement childDropdown = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Child\"]"));
		s = new Select(childDropdown);
		s.selectByValue("1");
		Thread.sleep(2000);

		WebElement infantDropdown = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Infant\"]"));
		s = new Select(infantDropdown);
		s.selectByValue("1");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void money() throws InterruptedException {

		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]"));
		s = new Select(dropDown);

		s.selectByIndex(1);
		Thread.sleep(3000);

		s.selectByValue("INR");
		Thread.sleep(3000);

		s.selectByVisibleText("USD");
		Thread.sleep(3000);

		// search
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();

	}

	@Test(priority = 1)
	public void fromToDropDown_cal() throws InterruptedException {
		WebElement from = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
		WebElement to = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));

		from.clear();
		from.sendKeys("BOM");

		Thread.sleep(2000);

		to.clear();
		to.sendKeys("GOI");

		Thread.sleep(2000);

		// cal
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[6]/a")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"Div1\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[6]/td[2]/a")).click();

	}

	@AfterTest
	public void end() throws InterruptedException {
		driver.close();
	}
}
