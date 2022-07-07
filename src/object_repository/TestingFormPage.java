package object_repository;

import org.openqa.selenium.By;

import base.MasterClass;

public class TestingFormPage extends MasterClass {

	public static By fName = By.id("ts_first_name");
	public static By lName = By.name("ts_last_name");
	public static By address = By.name("ts_address");
	public static By nationality = By.id("ts_country");
	public static By male = By.xpath("//input[starts-with(@value,'male')]");
	public static By female = By.xpath("//input[starts-with(@value,'female')]");
	public static By cricket = By.name("ts_checkbox1");
	public static By football = By.id("ts_checkbox2");
	public static By hockey = By.xpath("//input[contains(@value, 'Hockey')]");
	public static By submit = By.xpath("//input[starts-with(@name, 'Submit1')]");
	public static By pageHeading = By.xpath("//strong[starts-with(text(),'Automation')]");

	public static void formFill(String fname, String lname, String add, String citizen, String gender,
			String interest) {

		enterText(fName, fname);
		enterText(lName, lname);
		enterText(address, add);
		selectByText(nationality, citizen);

		if (gender.equalsIgnoreCase("Male")) {
			click(male);
		} else if (gender.equalsIgnoreCase("Female")) {
			click(female);
		} else {
			System.out.println("Invalid input : - " + gender);
		}

		if (interest.equalsIgnoreCase("Cricket")) {
			click(cricket);
		} else if (interest.equalsIgnoreCase("Football")) {
			click(football);
		} else if (interest.equalsIgnoreCase("Hockey")) {
			click(hockey);
		} else {
			System.out.println("Invalid input : - " + interest);
		}

		click(submit);
		alertAction("ok");

	}

}
