package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LandingPage {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	By signin=By.cssSelector(("a[href*='sign_in']"));
	By title=By.cssSelector(("#content > div > div > h2"));
	By navigation=By.cssSelector(("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul"));

public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	log.info(" driver is Initialized");
	}


public WebElement getlogin()
{
	return driver.findElement(signin);
}


public WebElement gettitle()
{
	return driver.findElement(title);
}
public WebElement getnavigatio()
{
	return driver.findElement(navigation);
}
}
