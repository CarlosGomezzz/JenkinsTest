package Carlos;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class listOfElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// login and navigate to nationalities page
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		// click on admin
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		// click on nationalities
		driver.findElement(By.id("menu_admin_nationality")).click();
		Thread.sleep(2000);
		List<WebElement> countries = driver.findElements(By.xpath("//*[@id=\"tableWrapper\"]/table/tbody/tr/td[2]"));
		for (int i = 0; i < countries.size(); i++) {
			WebElement oneCountry = countries.get(i);
			String unoOuntry = oneCountry.getText();
			System.out.println(i + " -- " + unoOuntry);
		}

	}
}
