package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	@DataProvider(name = "example1")
	public Integer[][] addition() {

		return new Integer[][] { { 3, 3 }, { 3, 4 }, { 3, 8 }, { 55, 3 } };
	}

	@Test(dataProvider = "example1")
	public void addItems(Integer number1, Integer number2) {
		System.out.println("The sum of two numbers is = " + (number1 + number2));
	}

}
