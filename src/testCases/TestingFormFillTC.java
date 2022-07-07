package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.MasterClass;
import object_repository.HomePageOR;
import object_repository.TestingFormPage;

public class TestingFormFillTC extends MasterClass {

	@BeforeClass
	public void preRun() {
		openBrowser("Chrome");

	}

	@Test
	public void formFilling() {
		openURL();
		HomePageOR.clickTestingFormPage();
		TestingFormPage.formFill("Mukesh", "Kumar", "NewYork", "America", "Male", "Hockey");

	}

	@AfterClass
	public void postRun() {
		shuttingDown();
	}
}
