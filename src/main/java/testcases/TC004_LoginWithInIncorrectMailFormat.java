package testcases;

import org.testng.annotations.Test;

import Wrappers.TestBase;
import pages.HomePage;

public class TC004_LoginWithInIncorrectMailFormat extends TestBase {
	
	@Test(priority = 3)
	public void login() throws Exception {
		new HomePage(driver).clickLoginButton().
		enterEmail(invalidMailId).enterPassword(password).invalidLogin()
				.verifyInvalidMailFromat();
	}
}