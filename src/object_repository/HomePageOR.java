package object_repository;

import org.openqa.selenium.By;

import base.MasterClass;

public class HomePageOR extends MasterClass {

	public static By testingFormPage = By.xpath("//a[contains(text(), 'Testing')]");
	public static By shortWait = By.xpath("//a[starts-with(text(),'Short Wait')]");

	public static void clickTestingFormPage() {
		click(testingFormPage);
	}

	public static void clickShortWait() {
		click(shortWait);
	}
}
