package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basePackage.BaseClass;

public class AccountInformationPage extends BaseClass {

	By titleLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='id_gender1']");
	By passwordLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='password']");
	By daySelectLocator = By.xpath("//form[contains(@action,'/signup')]//select[@id='days']");
	By monthSelectLocator = By.xpath("//form[contains(@action,'/signup')]//select[@id='months']");
	By yearSelectorLocator = By.xpath("//form[contains(@action,'/signup')]//select[@id='years']");
	By firstNameLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='first_name']");
	By lastNameLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='last_name']");
	By address1Locator = By.xpath("//form[contains(@action,'/signup')]//input[@id='address1']");
	By countrySelectorLocator = By.xpath("//form[contains(@action,'/signup')]//select[@id='country']");
	By stateLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='state']");
	By cityLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='city']");
	By zipcodeLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='zipcode']");
	By mobileNumberLocator = By.xpath("//form[contains(@action,'/signup')]//input[@id='mobile_number']");
	By createAccountLocator = By
			.xpath("//form[contains(@action,'/signup')]//button[@type='submit' and contains(text(),'Create Account')]");

	By successMessageLocator = By.xpath("//section[@id='form']//div//h2/b");
	By continueButtonLocator = By
			.xpath("//section[@id='form']//a[contains(@href,'/') and contains(text(),'Continue')]");
	By userNameLocator = By.xpath("//div[@class='shop-menu pull-right']//li/a[contains(text(),' Logged in as ')]");
	By deleteAccountLocator = By.xpath(
			"//div[@class='shop-menu pull-right']//li/a[contains(text(),' Delete Account') and contains(@href,'/delete')]");

	By accountDeleteMessageLocator = By.xpath("//section[@id='form']//b");
	By intermittentpopups = By.xpath("//div[contains(@id,'dismiss-button-element')]/div");
	By adpopLocator = By.xpath("//div[@class='ns-njqi5-e-15']/span[text()='Close']");

	private void clickTitle() {
		click(titleLocator);
	}

	private void closeAdpop() {
		click(adpopLocator);
	}

	private void sendPassword(String text) {
		sendKeys(text, passwordLocator);
	}

	private void selectDate(String text) {
		selectList(daySelectLocator, text);
	}

	private void selectMonth(String text) {
		selectList(monthSelectLocator, text);
	}

	private void selectYear(String text) {
		selectList(yearSelectorLocator, text);
	}

	private void sendFirstName(String text) {
		sendKeys(text, firstNameLocator);
	}

	private void sendlastName(String text) {
		sendKeys(text, lastNameLocator);
	}

	private void sendAddress1(String text) {
		sendKeys(text, address1Locator);
	}

	private void selectCountry(String text) {
		selectList(countrySelectorLocator, text);
	}

	private void sendState(String text) {
		sendKeys(text, stateLocator);
	}

	private void sendCity(String text) {
		sendKeys(text, cityLocator);
	}

	private void sendZipcode(String text) {
		sendKeys(text, zipcodeLocator);
	}

	private void sendMobileNumber(String text) {
		sendKeys(text, mobileNumberLocator);
	}

	private void clickSubmit() {
		click(createAccountLocator);
	}

	private void cickContinue() {
		click(continueButtonLocator);
	}

	private void cickdelete() {
		click(deleteAccountLocator);
	}

	private void closepopup(By locator) {
		elementVisibleClose(locator);
	}

	public void AccountInformationsFunctions(String password, String date, String month, String year, String firstName,
			String lastName, String address1, String country, String state, String city, String zipcode,
			String mobNumber) {
		clickTitle();
		sendPassword(password);
		selectDate(date);
		selectMonth(month);
		selectYear(year);
		sendFirstName(firstName);
		sendlastName(lastName);
		scrollDownToElement(address1Locator);
		sendAddress1(address1);
		selectCountry(country);
		sendState(state);
		scrollDownToElement(cityLocator);
		sendCity(city);
		sendZipcode(zipcode);
		sendMobileNumber(mobNumber);
		clickSubmit();
		String successMessage = webElementWaitGetText(successMessageLocator);
		Assert.assertTrue(successMessage.equalsIgnoreCase("Account Created!"));
		cickContinue();
//		closepopup(intermittentpopups);
		cickdelete();
		String accountDeletedMessage = webElementWaitGetText(accountDeleteMessageLocator);
		Assert.assertTrue(accountDeletedMessage.equalsIgnoreCase("Account Deleted!"));
		cickContinue();
	}

}
