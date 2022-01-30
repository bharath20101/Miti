
package Wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBase extends PageBase {

	@BeforeMethod
	public void beforeMethod() {
		invokeApp();
	}

	@AfterTest
	public void afterTest() {
		unloadObjects();
	}

	@AfterMethod
	public void afterMethod() {
		quitBrowser();

	}
}
