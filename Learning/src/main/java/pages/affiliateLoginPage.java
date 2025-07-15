package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class affiliateLoginPage {

	WebDriver driver;
	//WebDriverWait wait;
	
	//Locator
	By emailAddress = By.id("email");
	By userPassword = By.id("password");
	
	//Constructors
	public affiliateLoginPage(WebDriver driver) {
		this.driver = driver;
		//this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Verify the page using Title
	public void verifyTitle(String appTitle) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(appTitle, title);
		
	}
	
	@Before("LoginInfo")
	//Enter the details
	public void enterDetails(String email, String password) {
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(userPassword).sendKeys(password);
	}
	
	@Before("LoginInfo")
	public void clickLogin() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Log In']"));
       // wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		// Why use wait -> so that it can take its time load the page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("dashboard – Jump Spark"));
	}

}
