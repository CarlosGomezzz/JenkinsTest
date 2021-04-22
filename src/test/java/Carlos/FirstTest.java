package Carlos;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	@Test
	public void openFacebook() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com");

		boolean exist = driver.findElement(By.xpath("//button[contains(@name, 'login')]")).isDisplayed();

		assertTrue(exist);

//		driver.manage().window().maximize();

//		String expectedTitle = "Google";
//		String actualTitle = driver.getTitle();
//
//		assertEquals(expectedTitle, actualTitle);
	}
}