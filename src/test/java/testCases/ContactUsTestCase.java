package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testPages.ContactUsPage;
import testPages.LoginToAccount;
import utils.ExcelReader;

public class ContactUsTestCase {

	LoginToAccount login = new LoginToAccount();
	ContactUsPage contactusPage = new ContactUsPage();

	@Test(priority = 0, dataProvider = "login")
	public void login(String email, String password) throws IOException {
		login.init();
		login.loginPageFeatures(email, password);
	}

	@DataProvider(name = "login")
	public Object[][] login() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("loginuser");

	}

	@Test(priority = 1, dataProvider = "contactus")
	public void loginFunctions(String name, String email, String subject, String password) throws IOException

	{

		contactusPage.contactUsFunctions(name, email, subject, password);
	}

	@DataProvider(name = "contactus")
	public Object[][] getAccountInfo() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("contactUsForm");

	}

}
