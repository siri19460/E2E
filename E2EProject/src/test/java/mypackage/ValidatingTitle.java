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
import resources.Base;

public class ValidatingTitle extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
		log.info(" driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info(" navigated to home page");
	}
@Test
	
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage L=new LandingPage(driver);
		log.info(" driver is Initialized");
		Assert.assertEquals( L.gettitle().getText(),"FEATURED COURSES");
		log.info(" successfully validated text message");
	}
@AfterTest

public void teardown() {
	driver.close();

}
	}
