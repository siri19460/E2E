package mypackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavBar extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
		log.info(" driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test

	public void basePageNavigation() throws IOException {

		LandingPage L = new LandingPage(driver);

		Assert.assertTrue(L.getnavigatio().isDisplayed());
	}

	@AfterTest

	public void teardown() {
		driver.close();

	}
}
