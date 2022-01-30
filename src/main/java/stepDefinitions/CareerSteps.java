package stepDefinitions;

import org.testng.annotations.Test;

import Wrappers.PageBase;
import cucumber.api.java.en.*;
import pages.CareersPage;
import pages.HomePage;

@Test(priority=2)
public class CareerSteps extends PageBase {

	HomePage homePage;
	CareersPage careersPage;

	@Given("^User has launches Mitigram website$")
	public void user_has_launches_Mitigram_website() throws Throwable {
		invokeApp();
		homePage = new HomePage(driver);
}

	@When("^User selects careers page$")
	public void user_selects_careers_page() throws Throwable {
		careersPage = homePage.selectCareers();
	}

	@Then("^Careers page should open$")
	public void careers_page_should_open() throws Throwable {
		unloadObjects();
		quitBrowser();
	}

}
