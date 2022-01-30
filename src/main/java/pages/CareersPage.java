package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import Wrappers.PageBase;

public class CareersPage extends PageBase {

	public CareersPage(RemoteWebDriver driver) {
		this.driver = driver;
		if (!verifyTitle("Careers")) {
			System.out.println("This page is not careers page");
		}
	}

	public CareersPage clickOpenPositions() {
		clickByXpath("//a[text()='Open positions']");
		return this;
	}

	public CareersPage verifyOpenPositionForTestAutomationEngineerInStockholm() {
		String text = getText(
				"//div[@class='tm-wrapper' and child::a[text()='Test Automation Engineer'] and child::div[text()='Stockholm']]");
		System.out.println(text);
		if (text.contains("Test Automation Engineer") && text.contains("Stockholm")) {
			System.out.println("There is job opening for test Automation Engineer is Stockholm");
		} else {
			System.out.println("There is no job opening for test Automation Engineer is Stockholm");
		}
		return this;
	}
}
