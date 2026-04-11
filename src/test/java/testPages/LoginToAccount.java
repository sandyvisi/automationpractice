package testPages;

import org.openqa.selenium.By;
import org.testng.Assert;

import basePackage.BaseClass;

public class LoginToAccount extends BaseClass {
	private By signUpLocator = By.xpath(
			"//div[@class='shop-menu pull-right']//li//a[contains(text(),' Signup / Login') and contains(@href,'/login')]");
	private By emailLocator = By.xpath("//form[@action='/login']//input[@name='email']");
	private By passwordLocator = By.xpath("//form[@action='/login']//input[@name='password']");
	private By loginButtonLocator = By.xpath("//form[@action='/login']//button[contains(text(),'Login')]");

	private void clickOnSignUpLink(By locator) {
		click(locator);
	}

	private void enterEmail(By locator, String email) {

		sendKeys(email, locator);

	}

	private void enterPassword(By locator, String password) {

		sendKeys(password, locator);

	}

	private void clickLogin(By locator) {

		click(locator);

	}

	public void loginPageFeatures(String email, String password) {

		clickOnSignUpLink(signUpLocator);
		enterEmail(emailLocator, email);
		enterPassword(passwordLocator, password);
		clickLogin(loginButtonLocator);

	}

}
