package stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;

public class steps {

	
	@Given("^user is on the search page$")
	public void user_is_on_the_search_page() {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@When("^user enters \"([^\"]*)\" in the search box$")
	public void user_enters_in_the_search_box(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^user gets the atleast (\\d+) result in the search$")
	public void user_gets_the_atleast_result_in_the_search(int arg1) {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
