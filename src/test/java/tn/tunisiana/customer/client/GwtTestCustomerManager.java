package tn.tunisiana.customer.client;

import java.util.List;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.client.services.IOfferManagerServiceAsync;
import tn.tunisiana.customer.shared.model.CustomerDto;
import tn.tunisiana.customer.shared.model.OfferDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase. Using
 * <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 * 
 * If you run the tests using the Maven command line, you will have to navigate
 * with your browser to a specific url given by Maven. See
 * http://mojo.codehaus.org/gwt-maven-plugin/user-guide/testing.html for
 * details.
 */
public class GwtTestCustomerManager extends GWTTestCase {

	/**
	 * Must refer to a valid module that sources this class.
	 */
	public String getModuleName() {
		return "tn.tunisiana.customer.CustomerManagerJUnit";
	}

	/**
	 * Tests the FieldVerifier.
	 */
	// public void testFieldVerifier() {
	// assertFalse(FieldVerifier.isValidName(null));
	// assertFalse(FieldVerifier.isValidName(""));
	// assertFalse(FieldVerifier.isValidName("a"));
	// assertFalse(FieldVerifier.isValidName("ab"));
	// assertFalse(FieldVerifier.isValidName("abc"));
	// assertTrue(FieldVerifier.isValidName("abcd"));
	// }

	/**
	 * This test will send a request to the server using the greetServer method
	 * in GreetingService and verify the response.
	 */
	public void testGreetingService() {
		// Create the service that we will test.
		GreetingServiceAsync greetingService = GWT
				.create(GreetingService.class);
		ServiceDefTarget target = (ServiceDefTarget) greetingService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "CustomerManager/greet");

		// Since RPC calls are asynchronous, we will need to wait for a response
		// after this test method returns. This line tells the test runner to
		// wait
		// up to 10 seconds before timing out.
		delayTestFinish(10000);

		// Send a request to the server.
		greetingService.greetServer("GWT User", new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				// The request resulted in an unexpected error.
				fail("Request failure: " + caught.getMessage());
			}

			public void onSuccess(String result) {
				// Verify that the response is correct.
				System.out.println(result);
				assertTrue(result.startsWith("Hello, GWT User!"));

				// Now that we have received a response, we need to tell the
				// test runner
				// that the test is complete. You must call finishTest() after
				// an
				// asynchronous test finishes successfully, or the test will
				// time out.
				finishTest();
			}
		});
	}

	public void testOfferManagerService() {

		CustomerDto customer = new CustomerDto();
		customer.setAge(30);
		// Create the service that we will test.
		IOfferManagerServiceAsync omService = GWT
				.create(IOfferManagerService.class);
		ServiceDefTarget target = (ServiceDefTarget) omService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "CustomerManager/oManagerService");

		// Since RPC calls are asynchronous, we will need to wait for a response
		// after this test method returns. This line tells the test runner to
		// wait
		// up to 10 seconds before timing out.
		delayTestFinish(100000);

		// Send a request to the server.
		omService.getOffersFor(customer, new AsyncCallback<List<OfferDto>>() {
			public void onFailure(Throwable caught) {
				// The request resulted in an unexpected error.
				fail("Request failure: " + caught.getMessage());
			}

			public void onSuccess(List<OfferDto> result) {
				System.out.println(result.size());
				assertTrue(result != null);

			}
		});
	}
}
