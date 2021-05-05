package Carlos;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class homework2 {
	WebDriver driver;

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
		// get page title and button text
		Thread.sleep(2000);
		WebElement supplierBtn = driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[1]/div/a"));
		Thread.sleep(2000);
		System.out.println("BUTTON TITLE : " + supplierBtn.getText());
		System.out.println("PAGE TITLE : " + driver.getTitle());

		// get email and password
		String emailAndPassword = driver
				.findElement(By
						.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[2]/div[2]/div"))
				.getText();
		System.out.println();
		System.out.println("EMAIL AND PASSWORD INFO : " + emailAndPassword);
		System.out.println("LENGTH OF TEXT : " + emailAndPassword.length());
		String email = emailAndPassword.substring(6, 29);
		String password = emailAndPassword.substring(39);
		System.out.println();
		System.out.println("EMAIL ONLY : " + email);
		System.out.println("PASSWORD ONLY : " + password);
		Thread.sleep(2000);

		// click supplier button
		supplierBtn.click();
		Thread.sleep(2000);

		// switch to new window
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		driver.switchTo().window(childWin);

		// enter email and password
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/label[1]/input"));
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/label[2]/input"));
		emailInput.sendKeys(email);
		Thread.sleep(2000);
		passwordInput.sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/form[1]/button")).click();

		// list of tabs
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"social-sidebar-menu\"]")));
		System.out.println();
		List<WebElement> tabs = driver.findElements(By.xpath("//*[@id=\"social-sidebar-menu\"]"));
		for (int i = 0; i < tabs.size(); i++) {
			WebElement tabElement = tabs.get(i);
			String tabText = tabElement.getText();
			if (tabText.contains("WIDGETS")) {
				System.out.println("TEST PASSED! List contains 'WIDGETS'");
			} else {
				System.out.println("TEST FAILED!");
			}

		}
		System.out.println();
	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
