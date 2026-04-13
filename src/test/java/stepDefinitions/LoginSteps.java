package stepDefinitions;

import java.io.IOException;

import basePackage.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPages.LoginToAccount;

public class LoginSteps extends LoginToAccount {

	BaseClass baseclass = new BaseClass();
	LoginToAccount login = new LoginToAccount();

	@Given("User is on application login page")
	public void navigateToSignInpage() throws IOException {
		baseclass.init();
	}

	@When("User enters valid {string} and {string}")
	public void enterCredentials(String email, String password) throws IOException {
		login.loginPageFeatures(email, password);
	}

	@Then("The user is able to login successfully")
	public void closeBrowser() {
		baseclass.tearDown();
	}

}
