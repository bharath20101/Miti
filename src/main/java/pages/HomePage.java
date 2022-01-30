package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import Wrappers.PageBase;

public class HomePage extends PageBase {

	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
		if (!verifyTitle("Home")) {
			System.out.println("This page is not home page");
			;
		}
	}

	public LoginPage clickLoginButton() {
		//clickByXpath("jl-notification-close jl-close jl-icon");
		clickByXpath("(//a[text()='Log in'])[1]");
		clickByXpath("(//a[text()='Log in'])[2]");
		return new LoginPage(driver);
	}

	public CareersPage selectCareers() {
		scrollToBottom();
		clickByXpath("//a[text()='Careers']");
		return new CareersPage(driver);
	}

}