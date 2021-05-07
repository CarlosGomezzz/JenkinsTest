package Carlos;

import org.openqa.selenium.By;

import Utilities.ConfigurationReader;
import Utilities.Driver;

public class testingDriverClass {

	public static void main(String[] args) {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		Driver.getDriver().findElement(By.xpath(ConfigurationReader.getProperty("searchBox"))).sendKeys("");;
	}

}
