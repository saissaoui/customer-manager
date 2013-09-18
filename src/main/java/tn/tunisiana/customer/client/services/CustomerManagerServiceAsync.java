package tn.tunisiana.customer.client.services;

import tn.tunisiana.customer.shared.model.Customer;
import tn.tunisiana.customer.shared.model.Offer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CustomerManagerServiceAsync {

	void getCustomer(int id, AsyncCallback<Customer> callback);

	void saveCustomer(Customer customer, AsyncCallback<Integer> callback);

	void getOffer(AsyncCallback<Offer> callback);

}
