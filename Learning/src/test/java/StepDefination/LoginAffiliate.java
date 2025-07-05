package StepDefination;

import java.time.Duration;
import java.util.List;
import utilities.sharedContent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAffiliate {
	
	sharedContent content;
	
	public LoginAffiliate(sharedContent content) {
		this.content= content;
	}
	
	@Given("User login page")
	public void user_login_page() {
		content.driver.get("https://preprodjs.wpenginepowered.com/dashboard/");;
	}
	
	@When("title is {string}")
	public void title_is_JumpSpark(String title) {
		content.loginPage.verifyTitle(title);
		
	}
//simple and outline data driven testing	
	@Then("user enters {string} and {string}") 
	public void user_enters_email_id_and_password(String username, String password) {		
		content.loginPage.enterDetails(username, password);
	}
	
//	@Then("^user enters username and password$")
//	public void user_enter_username_and_password(DataTable credentials) {
//	    List<List<String>> data = credentials.asLists(String.class);
//	    driver.findElement(By.id("email")).sendKeys(data.get(0).get(0));
//	    driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
//	}

	
	@Then ("user click on login button")
	public void user_click_on_login_button() {
		content.loginPage.clickLogin();
	}
	@Then("login as affiliate {string}")
	public void login_as_affiliate(String title){
		content.loginPage.verifyTitle(title);
		
	}

	
}
