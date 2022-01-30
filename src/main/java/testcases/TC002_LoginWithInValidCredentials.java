package testcases;

import org.testng.annotations.Test;

import Wrappers.TestBase;
import pages.HomePage;

public class TC002_LoginWithInValidCredentials extends TestBase {

	@Test(priority = 2)
	public void login() throws Exception {
		new HomePage(driver).clickLoginButton()
		.enterEmail(mailId).enterPassword(password)
		.invalidLogin().verifyInvalidLogin();
	}
}