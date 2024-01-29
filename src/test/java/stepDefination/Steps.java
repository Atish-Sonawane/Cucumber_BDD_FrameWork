package stepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before; //cucumber.api.java.before.......>need
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		// Reading properties
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);

		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties"); // Added logger

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// configProp.getProperty("chromepath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			// System.setProperty("webdriver.chrome.driver",
			// configProp.getProperty("edgepath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			// System.setProperty("webdriver.chrome.driver",
			// configProp.getProperty("firefoxpath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		logger.info("*************** Launchimg browser ****************");

	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("********** Opening url *************");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@And("User enters Email as {string} ans Password as {string}")
	public void user_enters_email_as_ans_password_as(String email, String password) {
		logger.info("********** Providing login details *************");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@And("Click on Login")
	public void click_on_login() throws InterruptedException {
		logger.info("********** start login *************");
		lp.clickLogin();
		Thread.sleep(3000);

	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		System.out.println("Page titile is:"+driver.getTitle());
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("********** login pass *************");
			Assert.assertTrue(false);
		} else {
			logger.info("********** login failed *************");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(5000);

	}

	@When("User click on Logout link")
	public void user_click_on_logout_link(){
		logger.info("********** logout *************");
		lp.clickLogout();
	}


	@Then("close browser")
	public void close_browser() {
		logger.info("********** close browser *************");
		driver.close();
		driver.quit();

	}
	
	// Customer feature step Definition.............
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addcust = new AddCustomerPage(driver);
		Assert.assertEquals(addcust.getPageTitle(), "Dashboard / nopCommerce administration");
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_menu() {
	    addcust.clickOnCustomerMenu();
	}

	@When("click on customer Menu Item")
	public void click_on_customer_Menu_Item() {
	    addcust.clickOnCustomerMenuItem();
	}

	
	@When("click on Add new button")
	public void click_on_add_new_button() {
		addcust.clickOnAddNew();
	}

	@Then("User can View Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals(addcust.getPageTitle(), "Add a new customer / nopCommerce administration");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    logger.info("**************  Adding new Customer ******************");
	    logger.info("**************  providing customer details ******************");
	    String email = randomString()+"@gmail.com";
	    
	    addcust.setEmail(email);
	    addcust.setCustomerRole("Guest");
	    addcust.setGender("Male");
	    addcust.setFirstName("Tester");
	    addcust.setLastName("automation");
	    addcust.setDob("02/03/1999");
	    addcust.setCompanyName("SonQA");
	    addcust.setAdminContent("for Testing ..........");
	    
	    
	}

	@When("click on Save button")
	public void click_on_Save_button() {
		logger.info("**************  saving customer data ******************");
		addcust.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getAccessibleName().contains("The new customer has been added successfully"));
	}

	//----------------- Steps for searching customer using Mail ---------------------------------------
	
	
	@When("Enter customer EMail")
	public void enter_customer_Email() {
		logger.info("**************  searching customer by Email ******************");
		searchcust = new SearchCustomerPage(driver);
		searchcust.setEmail("victoriya_victoriya@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    searchcust.clickSearch();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_Search_table() {
	    boolean status = searchcust.searchCustomerByEmail("victoriya_victoriya@nopCommerce.com");
	    Assert.assertEquals(status, true);
	}

	//---------------------------- Steps for searching customer using Name -----------------------------------
	
	@When("Enter customer FirstName")
	public void enter_customer_firstName() {
		logger.info("**************  searching customer by Name ******************");
		searchcust = new SearchCustomerPage(driver);
		searchcust.setFirstName("victoriya");
	}

	@When("Enter customer LastName")
	public void enter_customer_lastFame() {
	    searchcust.setLastName("Terces");
	}
	@When("user should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		boolean status = searchcust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(status, true);
	}

}
