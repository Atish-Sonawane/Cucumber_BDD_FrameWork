package stepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomerPage searchcust;
	public static Logger logger;
	public Properties configProp;
	
	//creating random String for unique EmailID
	public static String randomString() {
		String generate = RandomStringUtils.randomAlphabetic(5);
		return generate;
	}

}
