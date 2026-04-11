package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import testPages.AccountInformationPage;
import utils.ExcelReader;

public class RegisterUser {
	BaseClass base = new BaseClass();
	AccountInformationPage accountPage = new AccountInformationPage();

//	@BeforeClass
//	public void init() throws IOException {
//		base.init();
//	}

	@Test(priority = 2, dataProvider = "accountInfo")
	public void accountInfo(String password, String date, String month, String year, String firstName, String lastName,
			String address1, String country, String state, String city, String zipcode, String mobNumber) {
		accountPage.AccountInformationsFunctions(password, date, month, year, firstName, lastName, address1, country,
				state, city, zipcode, mobNumber);
	}

	@DataProvider(name = "accountInfo")
	public Object[][] getAccountInfo() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("accountInformation");

	}

}
