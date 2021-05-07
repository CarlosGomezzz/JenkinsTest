package TestNG;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_XML_Practice {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(groups = "windowHandle")
	public void WindowHandle_HW() {
		driver.findElement(By.id("button1")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		driver.switchTo().window(childWin);
		driver.manage().window().maximize();
	}

	@Test(groups = "windowHandle")
	public void NewMessage_HW() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/div/p[3]/button")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWin1 = it.next();
		String childWin1 = it.next();
		driver.switchTo().window(childWin1);
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentWin1);
	}

	@Test
	public void AlertBox_HW() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test
	public void TimingAlert_HW() {
		driver.findElement(By.xpath("//button[@id='timingAlert']")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	@Test(enabled = false)
	public void DragMe_HW() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//button[@ondragover='allowDrop(event)']")));

		WebElement drag = driver.findElement(By.xpath("//button[@id='draga']"));
		WebElement drop = driver.findElement(By.xpath("//button[@ondragover='allowDrop(event)']"));
		action = new Actions(driver);
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();
	}

	@DataProvider(name = "contactInfo")
	public Object[][] ContacInfoProvider() {
		return new Object[][] { { "Carlos" }, { "carlos@carlos.com" }, { "5555555555" }, { "USA" }, { "TechCircle" },
				{ "Sup" } };
	}

	@Test(dataProvider = "contactInfo")
	public void ContacInfoRec(String val) {
		WebElement Name = driver
				.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[1]/input"));
		Name.click();
		if (val.contains("Carlos")) {
			Name.sendKeys(val);
		}

		WebElement Email = driver
				.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[2]/input"));
		Email.click();
		if (val.contains("@")) {
			Email.sendKeys(val);
		}

		WebElement PhoneNum = driver
				.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[3]/input"));
		PhoneNum.click();
		if (val.contains("5")) {
			PhoneNum.sendKeys(val);
		}

		WebElement Country = driver
				.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[4]/input"));
		Country.click();
		if (val.contains("USA")) {
			Country.sendKeys(val);
		}

		WebElement Company = driver
				.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div/span[5]/input"));
		Company.click();
		if (val.contains("Tech")) {
			Company.sendKeys(val);
		}

		WebElement Message = driver
				.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/span/textarea"));
		Message.click();
		if (val.contains("Sup")) {
			Message.sendKeys(val);
		}

		driver.findElement(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/p/a[1]")).click();

		
		
	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
