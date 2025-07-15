package utilities;

import org.openqa.selenium.WebDriver;

import pages.affiliateLoginPage;
import pages.inviteEmailPage;

public class sharedContent {
	
    public WebDriver driver;
    public affiliateLoginPage loginPage;
    public inviteEmailPage homeEmail;

	public sharedContent() {
		// TODO Auto-generated method stub
		driver = driverFactory.getDriver();
		homeEmail = new inviteEmailPage(driver);
		loginPage = new affiliateLoginPage(driver);
	}
	
	

}
