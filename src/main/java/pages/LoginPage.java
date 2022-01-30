package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import Wrappers.PageBase;

public class LoginPage extends PageBase {

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
		if (!verifyTitle("Mitigram")) {
			System.out.println("This page is not home page");
			;
		}
	}

	public LoginPage enterEmail(String emailId) {
		enterByXpath("//input[@name='Email']", emailId);
		return this;
	}

	public LoginPage enterPassword(String password) {
		enterByXpath("//input[@name='Password']", password);
		return this;
	}

	public UserPage login() {
		clickByXpath("//span[text()='Log in']");
		return new UserPage(driver);
	}

	public LoginPage invalidLogin() {
		clickByXpath("//span[text()='Log in']");
		return new LoginPage(driver);
	}

	public LoginPage verifyInvalidLogin() throws Exception {
		String errorText = getText("//div[text()='Invalid login attempt.']");
		if (errorText.equals("Invalid login attempt.")) {
			System.out.println(
					"WHen user tried to log in with invalid credentials, Invalid login attempt error is thrown");
		} else {
			throw new Exception();
		}
		return this;
	}
	
	public LoginPage verifyEmptyCredentials() throws Exception {
		String errorText = getText("//div[text()='Email is required']");
		if (errorText.contains("Email is required")) {
			System.out.println(
					"When user tried to log in with empty credentials, Email is required error is thrown");
		} else {
			throw new Exception();
		}
		return this;
	}
	
	public LoginPage verifyInvalidMailFromat() throws Exception {
		String errorText = getText("//div[text()='The Email field is not a valid e-mail address.']");
		if (errorText.equals("The Email field is not a valid e-mail address.")) {
			System.out.println(
					"When user tried to log in with invalid mail format, The Email field is not a valid e-mail address error is thrown");
		} else {
			throw new Exception();
		}
		return this;
	}
}
