package stepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HTTPSHelper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

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
	
	@Given("^user requests dash content stream$")
	public void user_requests_dash_content_stream() throws Exception {
		HTTPSHelper helper = new HTTPSHelper();
//		@SuppressWarnings("deprecation")
		org.apache.http.conn.ssl.SSLSocketFactory sslsf = helper.getSSLSocketFactory();
        Response response = RestAssured.given().config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().sslSocketFactory(sslsf))).when().get("https://ec2-108-128-174-166.eu-west-1.compute.amazonaws.com:7443/live/uk/bbc_one_northern_ireland_hd/bbc_one_northern_ireland_hd.isml/.MPD");
		System.out.println(response.body().asString());
	   
	}

	@When("^manifest and media chunks are received$")
	public void manifest_and_media_chunks_are_received() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^dash artifacts are according to our specs$")
	public void dash_artifacts_are_according_to_our_specs() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
}
