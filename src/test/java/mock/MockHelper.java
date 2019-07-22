package mock;

import org.mockserver.serverclient.MockServerClient;
import org.mockserver.client.initialize.ExpectationInitializer;

public class MockHelper implements ExpectationInitializer  {
	
	private MockServerClient mockServerClient;
	
	public MockHelper() {
	}
	
	@Override
	public void initializeExpectations(MockServerClient mockServerClient) {
		this.mockServerClient = mockServerClient;
		
	}
	
	
//	public void sampleExpectionHelloWord() {
//		
//		mockServerClient
//	    .when(
//	        request()
//	            .withMethod("POST")
//	            .withPath("/login")
//	            .withBody("{username: 'foo', password: 'bar'}")
//	    )
//	    .respond(
//	        response()
//	            .withStatusCode(302)
//	            .withCookie(
//	                "sessionId", "2By8LOhBmaW5nZXJwcmludCIlMDAzMW"
//	            )
//	            .withHeader(
//	                "Location", "https://www.mock-server.com"
//	            )
//	    );
//	}

}
