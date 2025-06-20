package StepDefination;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class leadLogin {
	WebDriver driver;
	
	@Given("User want started the lead process")
	public void user_want_started_the_lead_process() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();	
        driver.get("https://preprodjs.wpenginepowered.com/");
        driver.manage().window().maximize();
        //driver.navigate().refresh();

	}
	@When("title is JumpSpark FleetManagement")
	public void title_is_jump_spark_fleet_management() {
	    String t = driver.getTitle();
	    Assert.assertEquals("Jump Spark – Fleet Management",t);
	}
	@Then("user click on started")
	public void user_click_on_started() {
		WebElement btn = driver.findElement(By.cssSelector("a span span"));;
		btn.click();
	}
	
	@Then("user enters details in the file")
	public void user_enters_details_in_the_file(DataTable leadInfo) {
		driver.switchTo().frame("hs-form-iframe-0");
	    for (Map<String, String> leadMap : leadInfo.asMaps(String.class, String.class)) {
	        driver.findElement(By.xpath("//input[@id='firstname-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("FirstName"));
	        driver.findElement(By.xpath("//input[@id='lastname-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("LastName"));
	        driver.findElement(By.xpath("//input[@id='email-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("email"));
	        driver.findElement(By.xpath("//input[@id='phone-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("Number"));
	        driver.findElement(By.xpath("//input[@id='city-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("city"));
	        driver.findElement(By.xpath("//input[@id='company-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("CompanyName"));
	        driver.findElement(By.xpath("//input[@id='how_many_years_in_business_-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("BusinessYear"));
	        driver.findElement(By.xpath("//input[@id='current_fleet-2537e26e-386b-4c41-a78e-d767c7f9f843']")).sendKeys(leadMap.get("numberFleet"));
	    }
	}

	
	@Then("^user select the options \"(.*)\" and \"(.*)\"$")
	public void user_select_the_options_value1_and_value2(String value1, String value2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Use wait to until the element is visible and enabled before taking any action
	    WebElement familarLease = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='" + value1 + "']")));
	    familarLease.click();

	    // Wait and select second input
	    WebElement vechileRequire = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='" + value2 + "']")));
	    vechileRequire.click();
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Hear About Us: ");
	    String a = sc.nextLine();
	    WebElement hearAbout = driver.findElement(By.id("how_did_you_hear_about_us__-2537e26e-386b-4c41-a78e-d767c7f9f843"));
	    Select dropdown = new Select(hearAbout);
	    dropdown.selectByVisibleText(a);
	    
	    WebElement term = driver.findElement(By.xpath("//input[@id='LEGAL_CONSENT.subscription_type_370117470-2537e26e-386b-4c41-a78e-d767c7f9f843']"));
		term.click();
	}

	@Then("user can click submit")
	public void user_can_click_submit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Wait for the submit button using XPath
	    WebElement submitBtn = driver.findElement(
	        By.xpath("//input[@value='Submit']"));

	    //Scroll the button into view (so it's visible in viewport)
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);

	    //Try normal Selenium click
	    try {
	        submitBtn.click();
	    } catch (Exception e) {
	        //If normal click fails, use JavaScript to click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
	    }

	}
	@Then("message prompted")
	public void message_prompted() {
		 System.out.println("⏳ Waiting for user to complete CAPTCHA manually...");
		    
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2)); wait.until(ExpectedConditions.textToBePresentInElementLocated(
		        By.xpath("//div[@class='hbspt-form']/div[1]"),
		        "Thank you for submitting the form."
		    ));
		    
		WebElement a = driver.findElement(By.xpath("//div[@class='hbspt-form']/div[1]"));

		    // Get the actual text from the element
		    String actualMessage = a.getText();
		    System.out.println(actualMessage);
	}
	@Then("close the fleet browser")
	public void close_the_fleet_browser() {
		driver.quit();
	}
}

