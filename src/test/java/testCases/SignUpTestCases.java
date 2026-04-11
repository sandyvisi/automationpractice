package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import testPages.SignUpPage;
import utils.ExcelReader;

public class SignUpTestCases {

	BaseClass base = new BaseClass();
	SignUpPage signup = new SignUpPage();

	@BeforeTest
	public void init() throws IOException {
		base.init();
	}

	@Test(priority = 1, dataProvider = "signUpDatas")
	public void signUp(String name, String email) {
		signup.signUpPageFunctions(name, email);

	}

	@DataProvider(name = "signUpDatas")
	public Object[][] getSignUpDatas() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("signup");

	}

//	@AfterClass
//	public void closeBrowser() {
//		base.tearDown();
//	}

}
