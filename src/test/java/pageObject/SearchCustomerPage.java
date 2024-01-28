package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
WebDriver rdriver;
	public SearchCustomerPage(WebDriver driver) {
		this.rdriver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}
	public void clickSearch() {
		// TODO Auto-generated method stub
		
	}
	public boolean searchCustomerByEmail(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setLastName(String string) {
		// TODO Auto-generated method stub
		
	}
	public boolean searchCustomerByName(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
