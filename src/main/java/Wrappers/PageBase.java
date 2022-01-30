package Wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase implements IPageBase {

	public PageBase(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl;
	public String browserName;
	public WebDriverWait wait;
	public String mailId;
	public String password;
	public String invalidMailId;;

	public PageBase() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/java/Resources/config.properties")));
			sUrl = prop.getProperty("URL");
			browserName = prop.getProperty("Browser");
			mailId = prop.getProperty("mailId");
			password = prop.getProperty("password");
			invalidMailId = prop.getProperty("invalidMailId");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public RemoteWebDriver invokeApp() {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(sUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, 30);
		return driver;
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);

		} catch (NoSuchElementException e) {
			System.out.println("The data: " + data + " could not be entered in the field :" + xpathValue);
		} catch (Exception e) {
			System.out.println("Unknown exception occured while entering " + data + " in the field :" + xpathValue);
		}

	}

	public boolean verifyTitle(String title) {
		boolean titleStatus = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(title)) {
				System.out.println("the title of the page matches with the value :" + title);
				titleStatus = true;
			} else
				throw new Exception();
		} catch (Exception e) {
			System.out.println("the title of the does not matches with the value :" + title);
		}
		return titleStatus;
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
		} catch (NoSuchElementException e) {
			System.out.println("The element with xpath: " + xpathVal + " could not be clicked");
		} catch (Exception e) {
			System.out.println("Unable to click element");
		}
	}

	public String getText(String xpathVal) {
		String text = "";
		try {
			text = driver.findElement(By.xpath(xpathVal)).getText();
		} catch (NoSuchElementException e) {
			System.out.println("The element with xpath: " + xpathVal + " could not be found");
		} catch (Exception e) {
			System.out.println("Unknown exception occured while fetching text from the element :" + xpathVal);
		}
		return text;
	}

	public void scrollToBottom() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			System.out.println("An error occured while scrolling the webpage");
		}
	}

	public void unloadObjects() {
		prop = null;
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("The browser:" + driver.getCapabilities().getBrowserName() + " could not be closed.");
		}
	}

}
