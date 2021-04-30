package Carlos;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonSamsungPhone {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// search: phone
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone", Keys.ENTER);

		// phone
		List<WebElement> phones = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for (int i = 0; i < phones.size(); i++) {
			WebElement singlePhoneElement = phones.get(i);
			String phone = singlePhoneElement.getText();
			if (phone.contains("Samsung")) {
				System.out.println(i + " -- " + phone);
			}
		}

		Thread.sleep(3000);

		driver.close();

	}

}
