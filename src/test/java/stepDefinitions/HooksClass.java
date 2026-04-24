package stepDefinitions;

import java.io.IOException;

import basePackage.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass {

	BaseClass baseclass = new BaseClass();

	@Before
	public void beforeScenario() throws IOException {

		baseclass.init();
	}

	@After
	public void afterScenario() {

		baseclass.tearDown();
	}

}
