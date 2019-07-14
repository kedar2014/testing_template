import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class PageObjectManager {
	
	public WebDriver driver;
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? new LoginPage(driver) : loginPage;
	}

}
