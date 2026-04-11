package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import testPages.LoginToAccount;
import utils.ExcelReader;

public class LoginUserCase {

	BaseClass base = new BaseClass();
	LoginToAccount login = new LoginToAccount();

//	@BeforeClass
//	public void init() throws IOException {
//		base.init();
//	}

	@Test(priority = 2, dataProvider = "login")
	public void loginFunctions(String email, String password) throws IOException

	{
		login.init();
		login.loginPageFeatures(email, password);
	}

	@DataProvider(name = "login")
	public Object[][] getAccountInfo() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("loginuser");

	}

}
