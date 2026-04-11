package testPages;

import org.openqa.selenium.By;
import org.testng.Assert;

import basePackage.BaseClass;

public class SignUpPage extends BaseClass {

	private By signUpLocator = By.xpath(
			"//div[@class='shop-menu pull-right']//li//a[contains(text(),' Signup / Login') and contains(@href,'/login')]");
	private By nameLocator = By.xpath("//form[@action='/signup']//input[@name='name']");
	private By emailLocator = By.xpath("//form[@action='/signup']//input[@name='email']");
	private By signupButtonLocator = By.xpath("//form//button[@type='submit' and contains(text(),'Signup')]");
	private By formHeader = By.xpath("//section[@id='form']//div[@class='login-form']/h2/b");

	private void clickOnSignUpLink(By locator) {

		click(locator);

	}

	private void enterName(By locator, String text) {

		sendKeys(text, locator);

	}

	private void enterEmail(By locator, String text) {

		sendKeys(text, locator);

	}

	private void clickSignUpButton(By locator) {

		click(locator);

	}

	public void signUpPageFunctions(String name, String email) {

		clickOnSignUpLink(signUpLocator);
		enterName(nameLocator, name);
		enterEmail(emailLocator, email);
		clickSignUpButton(signupButtonLocator);
		String headerText = webElementWaitGetText(formHeader);
		System.out.println(headerText);
		Assert.assertTrue(headerText.equalsIgnoreCase("Enter Account Information"));
	}

}
