package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNG_Annotation {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}

	// ----------------------------

	@Test(enabled = true)
	public void test1() {
		System.out.println("test 1");
	}

	@Test(priority = 0, groups = "smoke test")
	public void test2() {
		System.out.println("test 2");
	}

	@Test(groups = "smoke test")
	public void test3() {
		System.out.println("test 3");
	}

	@Test(dependsOnMethods = "test1") // will need 'test1' to pass before executing
	public void test4() {
		System.out.println("test 4");
	}

	@Test(dependsOnGroups = "smoke test") // will need group 'smoke test' to pass before execution
	public void test5() {
		System.out.println("test 5");
	}

	// ----------------------------

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}

	@AfterGroups
	public void afterGroups() {
		System.out.println("After groups");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("After suite");
	}

}
