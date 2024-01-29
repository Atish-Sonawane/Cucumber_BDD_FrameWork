package pageObject;

import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	WebDriver rdriver;

	public SearchCustomerPage(WebDriver driver) {
		this.rdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(xpath = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(id = "Search-customer")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(xpath = "//input[@role='grid']")
	@CacheLookup
	WebElement tblSearchResult;

	@FindBy(xpath = "//table[@id= 'customer-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(xpath = "//table[@id= 'customer-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id= 'customer-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumn;

	public void setEmail(String email) {
		// WaitHelper.waitForElement(txtEmail, 10);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {
		// WaitHelper.waitForElement(txtFirstName, 10);
		txtFirstName.clear();
		txtLastName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		// WaitHelper.waitForElement(txtLastName, 10);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void clickSearch() {
		btnSearch.click();
	}

	public int getNoofRows() {
		return (tableRows.size());
	}

	public int getNoofColumn() {
		return (tableColumn.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;

		for (int i = 1; i < getNoofRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id= 'customer-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(emailid);
			if (emailid.equals("victoria_victoria@nopCommerce.com")) {
				flag = true;
			}
		}

		return flag;
	}

	public boolean searchCustomerByName(String string) {
		boolean flag = false;

		for (int i = 1; i < getNoofRows(); i++) {
			String name = table.findElement(By.xpath("//table[@id= 'customer-grid']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			String names[] = name.split(" "); // for separating fname and lastname
			if (names[0].equals("victoriya") && names[1].equals("Terces")) {
				flag = true;
			}
		}

		return flag;
	}

}
