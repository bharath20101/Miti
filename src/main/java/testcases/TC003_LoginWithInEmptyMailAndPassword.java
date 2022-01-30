package testcases;

import org.testng.annotations.Test;

import Wrappers.TestBase;
import pages.HomePage;

public class TC003_LoginWithInEmptyMailAndPassword extends TestBase {

	@Test(priority = 3)
public void login() throws Exception {
		new HomePage(driver).clickLoginButton()
		.enterEmail("").enterPassword("")
		.invalidLogin().verifyEmptyCredentials();
	}
}