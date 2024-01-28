package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement lnkCustMenu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement linkCustMenuItem;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	@CacheLookup
	WebElement btnAddnew;

	@FindBy(xpath = "//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='FirstName']")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(id = "Gender_Male")
	@CacheLookup
	WebElement rdMaleGender;

	@FindBy(id = "Gender_Female")
	@CacheLookup
	WebElement rdFemaleGender;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	@CacheLookup
	WebElement txtDob;

	@FindBy(xpath = "//input[@id='Company']")
	@CacheLookup
	WebElement txtCompanyName;

	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	@CacheLookup
	WebElement checktaxExempt;

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtcustomerRoles;

	@FindBy(xpath = "//li[normalize-space()='Administrators']")
	@CacheLookup
	WebElement lstitemAdministrator;

	@FindBy(xpath = "//li[normalize-space()='Registered']")
	@CacheLookup
	WebElement lstitemRegister;

	@FindBy(xpath = "//li[normalize-space()='Guests']")
	@CacheLookup
	WebElement lstitemGuest;

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;

	@FindBy(xpath = "//select[@id='VendorId']")
	@CacheLookup
	WebElement drpmgrofVender;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	@CacheLookup
	WebElement txtAdminComment;

	@FindBy(xpath = "//button[@name='save']")
	@CacheLookup
	WebElement btnSave;

	// Action Methods

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickOnCustomerMenu() {
		lnkCustMenu.click();
	}

	public void clickOnCustomerMenuItem() {
		linkCustMenuItem.click();
	}

	public void clickOnAddNew() {
		btnAddnew.click();
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setCustomerRole(String role) throws InterruptedException {
		if (role.equals("Vendors")) {
			txtcustomerRoles.click();
		}

		else if (role.equals("Administrator")) {
			lstitemAdministrator.click();
		}

		else if (role.equals("Guests")) {
			lstitemGuest.click();
		}

		else if (role.equals("Registered")) {
			lstitemRegister.click();
		} else {
			lstitemGuest.click(); // default
		}

	}

	public void setManagerofVendor(String value) {
		Select drp = new Select(lstitemVendors);
		drp.selectByValue(value);

	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			rdMaleGender.click();
		} else if (gender.equals("Female")) {
			rdFemaleGender.click();
		} else {
			rdMaleGender.click(); // default
		}

	}

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setDob(String dob) {
		txtDob.sendKeys(dob);
	}

	public void setCompanyName(String compName) {
		txtCompanyName.sendKeys(compName);
	}

	public void setAdminContent(String comment) {
		txtAdminComment.sendKeys(comment);
	}

	public void clickOnSave() {
		btnSave.click();
	}

}
