package testcases;

import org.testng.annotations.Test;

import Wrappers.TestBase;
import pages.HomePage;

public class TC005_GoToCareersPageAndCheckOpeningsForTestAutomationEngineerinStockholm extends TestBase {

	@Test(priority = 5)
public void login() throws Exception {
		new HomePage(driver).selectCareers()
		.clickOpenPositions().verifyOpenPositionForTestAutomationEngineerInStockholm();	
	}
}