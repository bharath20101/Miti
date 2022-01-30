package Wrappers;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface IPageBase {

	public RemoteWebDriver invokeApp();
	
	public void enterByXpath(String xpathValue, String data);
	
	public boolean verifyTitle(String title);
	
	public void clickByXpath(String xpathVal);
	
	public String getText(String xpathVal);
		
	public void scrollToBottom();
	
	public void quitBrowser();
}
