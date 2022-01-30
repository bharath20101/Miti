package stepDefinitions;

import org.testng.annotations.Test;

import Wrappers.PageBase;
import cucumber.api.java.en.*;
import pages.*;

@Test(priority=1)
public class LoginSteps extends PageBase {

	HomePage homePage;
	LoginPage loginPage;

	@Given("User has launched Mitigram website")
	public void user_has_launched_mitigram_website() {
		invokeApp();
		homePage = new HomePage(driver);
	}

	@Given("User clicks Log in button")
	public void user_clicks_log_in_button() {
		loginPage = homePage.clickLoginButton();
	}

	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
		loginPage.enterEmail(arg1).enterPassword(arg2);
	}

	@When("User selects Log in button from log in page")
	public void user_selects_log_in_button_from_log_in_page() {
		loginPage.login();
		unloadObjects();
		quitBrowser();
	}
}
