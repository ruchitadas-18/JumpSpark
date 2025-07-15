package StepDefination;

import utilities.sharedContent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class inviteEmail {
	
	sharedContent content;
	
	public inviteEmail(sharedContent content) {
		this.content = content;
	}
	
	@Given("user is logged in as affiliate {string}")
	public void user_is_logged_in_as_affiliate(String title) {
	   //Pre Requite is running
	}
	@When("title is changed to Dashboard")
	public void title_is_changed_to_dashboard() {
		content.homeEmail.verifyTheTitle();
	}
	@When("user enters an email")
	public void user_enters_an_email() {
	   
	}
	@When("clicks on send email")
	public void clicks_on_send_email() {
	   
	}
	@Then("email sent pop-up appears")
	public void email_sent_pop_up_appears() {
	    
	}
	
	@When("clicks on Add Another")
	public void clicks_on_add_another() {
	    
	}
	@When("user enters another email")
	public void user_enters_another_email() {
	  
	}
	
	@When("user leaves the email field empty")
	public void user_leaves_the_email_field_empty() {
	    
	}
	
	@Then("error message appears")
	public void error_message_appears() {
	   
	}
	
	@When("user enters an invalid email")
	public void user_enters_an_invalid_email() {
	  
	}
	
	@When("user enters two emails")
	public void user_enters_two_emails() {
	    
	}
	@When("clicks on remove next to one email")
	public void clicks_on_remove_next_to_one_email() {
	    
	}
	@Then("email sent pop-up appears for the remaining email")
	public void email_sent_pop_up_appears_for_the_remaining_email() {
	    
	}
	
	@When("user enters multiple valid emails")
	public void user_enters_multiple_valid_emails() {
	    
	}
	
	@Then("confirmation pop-up displays the list of emails invited")
	public void confirmation_pop_up_displays_the_list_of_emails_invited() {
	   
	}
	
}
