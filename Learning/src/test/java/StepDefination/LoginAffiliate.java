package StepDefination;

import java.time.Duration;
import java.util.List;

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
	WebDriver driver;
	@Given("^User login page$")
	public void user_login_page() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://preprodjs.wpenginepowered.com/dashboard/");
	}
	
	@When("^title is JumpSpark$")
	public void title_is_JumpSpark() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("login – Jump Spark", title);
	}
//simple and outline data driven testing	
	@Then("^user enters \"(.*)\" and \"(.*)\"$") 
	public void user_enters_email_id_and_password(String username, String password) {		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
//	@Then("^user enters username and password$")
//	public void user_enter_username_and_password(DataTable credentials) {
//	    List<List<String>> data = credentials.asLists(String.class);
//	    driver.findElement(By.id("email")).sendKeys(data.get(0).get(0));
//	    driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
//	}

	
	@Then ("^user click on login button$")
	public void user_click_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Log In']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}
	@Then("^login as affiliate$")
	public void login_affiliate() {
		
		// Why use wait -> so that it can take its time load the page 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("dashboard – Jump Spark"));
		
		//storing the title in a variable
		String a= driver.getTitle();
		System.out.println(a);
		Assert.assertEquals("dashboard – Jump Spark", a);
	}
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

	
}
