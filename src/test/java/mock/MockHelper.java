
package mock;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockserver.model.HttpResponse.notFoundResponse;


import org.mockserver.client.MockServerClient;
import org.mockserver.client.initialize.ExpectationInitializer;

public class MockHelper implements ExpectationInitializer {
	ExecutorService executorService = null;
	VideoStreamingClass videoStreamingClass = null;
	@Override
	public void initializeExpectations(MockServerClient mockServerClient) {
		mockServerClient
		.when(
				request()
				.withPath("/simpleFirst")
				)
		.respond(
				response()
				.withBody("some first response")
				);


		mockServerClient
		.when(
				request()
				.withPath("/simpleSecond")
				)
		.respond(
				response()
				.withBody("some second response")
				);

		mockServerClient
		.when(
		        request()
		            .withPath("/startStreams")
		    )
		    .respond(
		        request -> {
		            if (request.getMethod().getValue().equals("GET")) {
		            	executorService = Executors.newFixedThreadPool(1);
		            	videoStreamingClass = new VideoStreamingClass();
		            	executorService.execute(videoStreamingClass);
		            	
		                return response()
		                    .withStatusCode(202)
		                    .withBody("started Streams");
		            } else {
		                return notFoundResponse();
		            }
		        }
		    );
		mockServerClient
		.when(
		        request()
		            .withPath("/stopStreams")
		    )
		    .respond(
		        request -> {
		            if (request.getPath().getValue().contains("stopStreams")) {
		            	System.out.println("inside stop code");
		               	videoStreamingClass.stopStreams();
		            	executorService.shutdown();
		            	
		                return response()
		                    .withStatusCode(202)
		                    .withBody("stopped Streams");
		            } else {
		                return notFoundResponse();
		            }
		        }
		    );

	}

}
