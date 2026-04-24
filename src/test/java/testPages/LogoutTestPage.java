package testPages;

import org.openqa.selenium.By;

import basePackage.BaseClass;

public class LogoutTestPage extends BaseClass {

	private By logoutLocator = By
			.xpath("//header[@id='header']//ul//li/a[contains(@href,'/logout') and contains(text(),'Logout')]");

	private void clickLogut(By locator) {

		click(locator);
	}

	public void logout() {

		clickLogut(logoutLocator);

	}

}
