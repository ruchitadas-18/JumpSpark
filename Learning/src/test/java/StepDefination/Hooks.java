package StepDefination;

import io.cucumber.java.Before;
import pages.affiliateLoginPage;
import utilities.driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {
    WebDriver driver;
    affiliateLoginPage loginPage;

    @Before("@LoginInfo")
    public void loginBeforeScenario() {
        driver = driverFactory.getDriver();
        loginPage = new affiliateLoginPage(driver);

        driver.get("https://preprodjs.wpenginepowered.com/login/");
        loginPage.enterDetails("ruchita.das@omnireach.app","Tmv@abcdefghi!123");
        loginPage.clickLogin();
        
    }
}
