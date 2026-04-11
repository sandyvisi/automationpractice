package testPages;

import org.openqa.selenium.By;

import basePackage.BaseClass;

public class ContactUsPage extends BaseClass {

	String filePath = "D:\\Desktop\\requirement\\corejavabasics.txt";

	private By contactUsLocator = By.xpath(
			"//div[@class='shop-menu pull-right']//li//a[contains(text(),'Contact us') and contains(@href,'/contact_us')]");

	private By nameLocator = By.xpath("//form[@id='contact-us-form']//div/input[@name='name']");
	private By emailLocator = By.xpath("//form[@id='contact-us-form']//div/input[@name='email']");
	private By subjectLocator = By.xpath("//form[@id='contact-us-form']//div/input[@name='subject']");
	private By textAreaLocator = By.xpath("//form[@id='contact-us-form']//div/textarea[@name='message']");
	private By uploadFileLocator = By.xpath("//form[@id='contact-us-form']//div/input[@name='upload_file']");
	private By submitLocator = By.xpath("//form[@id='contact-us-form']//div/input[@name='submit']");

	private void clickOnContactUs(By locator) {
		click(locator);
	}

	private void enterName(By locator, String email) {

		sendKeys(email, locator);

	}

	private void enterEmail(By locator, String email) {

		sendKeys(email, locator);

	}

	private void enterSubject(By locator, String password) {

		sendKeys(password, locator);

	}

	private void entertextArea(By locator, String password) {

		sendKeys(password, locator);

	}

	private void uploadFile(By locator, String password) {

		sendKeys(password, locator);

	}

	private void clickSubmit(By locator) {

		click(locator);

	}

	public void contactUsFunctions(String name, String email, String subject, String password) {

		clickOnContactUs(contactUsLocator);
		enterName(nameLocator, name);
		enterEmail(emailLocator, email);
		enterSubject(subjectLocator, subject);
		entertextArea(textAreaLocator, password);
		uploadFile(uploadFileLocator, filePath);
		scrollDownToElement(submitLocator);
		clickSubmit(submitLocator);
		moveToAlertAndAccept();

	}

}
