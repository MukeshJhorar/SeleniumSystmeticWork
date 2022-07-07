package base;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MasterClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String ScreenShotName;

	public static void openBrowser(String browserName) {
		if (extent == null) {
			extent = new ExtentReports("E:\\SeleniumCoding\\SeleniumSystmeticWork\\Reports\\FirstReport.html", true);
			extent.loadConfig(new File("E:\\SeleniumCoding\\SeleniumSystmeticWork\\Reports\\ReportsConfig.xml"));

			try {
				if (browserName.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					System.out.println(browserName + " browser up and running");
				} else if (browserName.equalsIgnoreCase("Edge")) {
					System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					System.out.println(browserName + " browser up and running");
				} else if (browserName.equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.gecko.driver",
							"E:\\SeleniumCoding\\SeleniumSystmeticWork\\Drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					System.out.println(browserName + " browser up and running");
				} else {
					System.out.println("UNABLE to launch browser : - " + browserName);
				}
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	
	

	public static void openURL() {
		try {
			driver.get("https://seleniumautomationpractice.blogspot.com/");
			System.out.println("AUT ia up and running : - ");
		} catch (Exception e) {
			System.out.println("UNABLE to running AUT : - ");
		}
	}

	public static void click(By locName) {
		try {
			driver.findElement(locName).click();
			System.out.println("Click on the element having locator : - " + locName);
		} catch (Exception e) {
			System.out.println("UNABLE to click on the element having locator : - " + locName);
		}

	}

	public static void enterText(By locName, String data) {
		try {
			driver.findElement(locName).clear();
			driver.findElement(locName).sendKeys(data);
			System.out.println("Enter the " + data + " into the textbox having locator : - " + locName);
		} catch (Exception e) {
			System.out.println("UNABLE to enter the " + data + " into the textbox having locator : - " + locName);
		}

	}
	
	
	public static void selectByText(By locName, String text) {
		try {
			new Select(driver.findElement(locName)).selectByVisibleText(text);
			System.out.println("Enter the "+text+" into the textbox having locator : - "+locName);
		} catch (Exception e) {
			System.out.println("UNABLE to enter the "+text+" into the textbox having locator : - "+locName);
		}
	}
	
	
	public static void selectByValue(By locName, String value) {
		try {
			new Select(driver.findElement(locName)).selectByValue(value);
			System.out.println("Enter the "+value+" into the textbox having locator : - "+locName);
		} catch (Exception e) {
			System.out.println("UNABLE to enter the "+value+" into the textbox having locator : - "+locName);
		}
	}
	
	
	public static void selectByIndex(By locName, int indexNo) {
		try {
			new Select(driver.findElement(locName)).selectByIndex(indexNo);
			System.out.println("Select the option having index position"+indexNo+" using  : - "+locName);
		} catch (Exception e) {
			System.out.println("UNABLE to select the option having index position"+indexNo+" using  : - "+locName);
		}
	}
	
	
	public static void alertAction(String action) {
		try {
			if (action.equalsIgnoreCase("ok")) {
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
			}
			else if (action.equalsIgnoreCase("cancel")) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
			System.out.println("ERROR in perfofming action on alert box "+action+" fail");
		}
	}
	
	
	
	
	
	
	
	
	
	
	

	public static void captureScreenshot() {
		Date d = new Date();

		String d1 = d.toString().replace(":", "_").replace(" ", "_");

		ScreenShotName = "Screen_" + d1 + ".jpg";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destpath = "E:\\SeleniumCoding\\SeleniumSystmeticWork\\Reports\\ScreenshotFolder_1\\" + ScreenShotName;
		File dest = new File(destpath);
		try {
			FileUtils.copyFile(src, dest);
			System.out.println("---- Screenshots is captured");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		logger.log(LogStatus.INFO, logger.addScreenCapture(destpath));

	}
	
	public static void selectAllCheckBoxes(By locName) {

		try {
			List<WebElement> elements = driver.findElements(locName);
			System.out.println(elements.size());
			for (WebElement webElement : elements) {
				webElement.click();
			}
			System.out.println("All check box is selected : - "+elements);
		} catch (Exception e) {
			System.out.println("UNABLE to select all check boxes : - "+e.getMessage());
		}
	}
	
	
	
	
	
	public static void shuttingDown() {
		driver.quit();
		System.out.println("Quitting the execution process.");
	}

}
