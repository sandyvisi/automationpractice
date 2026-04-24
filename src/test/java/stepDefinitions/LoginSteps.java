package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.When;
import testPages.LoginToAccount;

public class LoginSteps extends LoginToAccount {

	LoginToAccount login = new LoginToAccount();

	@When("User enters valid {string} and {string}")
	public void enterCredentials(String email, String password) throws IOException {
		login.loginPageFeatures(email, password);
	}

}
