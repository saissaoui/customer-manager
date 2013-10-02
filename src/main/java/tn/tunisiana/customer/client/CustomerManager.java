package tn.tunisiana.customer.client;

//import tn.tunisiana.customer.client.services.CustomerManagerService;
import tn.tunisiana.customer.client.views.CustomerForm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CustomerManager implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
 
  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  

	  CustomerForm customerForm =  new CustomerForm();
	  RootPanel.get().add(customerForm);  
	 // Document.get().getBody().appendChild(customerForm.getElement());

  }
}
