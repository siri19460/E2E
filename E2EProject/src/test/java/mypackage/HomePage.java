package mypackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{

public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
		log.info(" driver is Initialized");
		
	}


	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to home page");
		LandingPage L=new LandingPage(driver);
		L.getlogin().click();
		LoginPage LP=new LoginPage(driver);
		LP.getEmail().sendKeys(username);
		LP.getPassword().sendKeys(password);
	
		LP.getLogin().click();
	}
	
	
 @DataProvider
 public Object[][] getData(){
 
 //row stands for how many different data types test should run
 //column stands for how many values per each test
	 // 0 row
  Object[][] data= new Object[2][2];
  data[0][0]="nonrestrictrduser@qa.com";
  data[0][1]="12345";
  //data[0][2]="restricteduser";
  
  //1 st row

  data[1][0]="restrictrduser@qa.com";
  data[1][1]="12345";
  //data[0][2]="restricteduser";
  
return data;
		  
}
 @AfterTest

 public void teardown() {
 	driver.close();

 }

}