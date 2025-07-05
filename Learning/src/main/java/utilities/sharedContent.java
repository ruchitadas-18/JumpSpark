package utilities;

import org.openqa.selenium.WebDriver;

import pages.affiliateLoginPage;
import pages.inviteEmail;

public class sharedContent {
	
    public WebDriver driver;
    public affiliateLoginPage loginPage;
    public inviteEmail homeEmail;

	public sharedContent() {
		// TODO Auto-generated method stub
		driver = driverFactory.getDriver();
		homeEmail = new inviteEmail(driver);
		loginPage = new affiliateLoginPage(driver);
	}
	
	

}
