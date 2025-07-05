package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class affiliateLoginPage {

	WebDriver driver;
	
	//Locator
	By emailAddress = By.id("email");
	By userPassword = By.id("password");
	
	//Constructors
	public affiliateLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Verify the page usig Title
	public void verifyTitle(String appTitle) {
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(appTitle, title);
		
	}
	
	//Enter the details
	public void enterDetails(String email, String password) {
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(userPassword).sendKeys(password);
	}
	
	
	public void clickLogin() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Log In']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		// Why use wait -> so that it can take its time load the page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("dashboard – Jump Spark"));
	}
	

}
