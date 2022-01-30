package testcases;

import org.testng.annotations.Test;

import Wrappers.TestBase;
import pages.HomePage;

public class TC001_LoginWithValidCredentials extends TestBase {

	@Test(priority = 1)
	public void login() {
		new HomePage(driver).clickLoginButton().enterEmail(mailId).enterPassword(password).login();
	}
}
