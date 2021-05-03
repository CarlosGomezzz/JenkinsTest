package Carlos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class homework1 {
	WebDriver driver;
	Actions action;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		// draggable
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		System.out.println(iframe.getSize());
		driver.switchTo().frame(iframe);
		WebElement draggable = driver.findElement(By.id("draggable"));
		action = new Actions(driver);
		action.dragAndDropBy(draggable, 300, 110).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// droppable
		driver.findElement(By.xpath("//a[contains(@href, 'https://jqueryui.com/droppable/')]")).click();
		WebElement iframe2 = driver.findElement(By.tagName("iframe"));
		System.out.println(iframe2.getSize());
		driver.switchTo().frame(iframe2);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// resizable
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a")).click();
		WebElement iframe3 = driver.findElement(By.tagName("iframe"));
		System.out.println(iframe3.getSize());
		driver.switchTo().frame(iframe3);
		WebElement arrow = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Thread.sleep(2000);
		action.dragAndDropBy(arrow, 50, 50).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		// sortable
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[5]/a")).click();
		WebElement iframe4 = driver.findElement(By.tagName("iframe"));
		System.out.println(iframe4.getSize());
		driver.switchTo().frame(iframe4);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
		WebElement element6 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[6]"));
		action.clickAndHold(element1).moveToElement(element6).moveByOffset(0, 10).release().build().perform();
		Thread.sleep(2000);
	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
