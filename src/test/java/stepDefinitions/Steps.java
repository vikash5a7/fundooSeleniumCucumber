package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.LoginPage;
import utility.UtilClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		// Logger steps
		logger = Logger.getLogger("Fundoo Notes");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		// Logger steps done

		// Loading Config.properties file steps
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		// Loading Config.properties file is done

		String br = configProp.getProperty("browser");

		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}

		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}

	}

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {

		logger.info("********* Launching browser***************");
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("********* Opening URL***************");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {

		logger.info("********* Proving user info ***************");
		lp.setEmailAddress(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickSubmit();
		Thread.sleep(5000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String exptitle) throws Exception {
		logger.info("*********Login Validation starts ***************");

		if (exptitle.equals(driver.getTitle())) {
			logger.info("*********Login successfull ***************");
			Assert.assertEquals(exptitle, driver.getTitle());
		} else {
			logger.info("*********Login Failed ***************");
			
			String ScreenSortName = "loginTest" + UtilClass.randomeNum(5);
			UtilClass.takeSnapShot(driver, ScreenSortName);
			logger.info("Screent sort name is " + ScreenSortName);
			Thread.sleep(5000);
			driver.close();
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("*********Logout from application***************");
		lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("*********Closing application ***************");
		driver.quit();
	}

}
