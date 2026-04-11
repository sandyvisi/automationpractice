package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testPages.LoginToAccount;
import testPages.ViewProductsPage;
import utils.ExcelReader;

public class ViewProductsCase {

	LoginToAccount login = new LoginToAccount();
	ViewProductsPage viewproducts = new ViewProductsPage();

	@Test(priority = 0, dataProvider = "login")
	public void login(String email, String password) throws IOException {
		login.init();
		login.loginPageFeatures(email, password);
	}

	@DataProvider(name = "login")
	public Object[][] login() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("loginuser");

	}

	@Test(priority = 1)
	public void viewProductFunctions() {

		viewproducts.viewProductsFunctions();
	}

}
