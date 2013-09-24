package tn.tunisiana.customer.client.services;

import java.util.List;

import tn.tunisiana.customer.shared.model.Customer;
import tn.tunisiana.customer.shared.model.Offer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IOfferManagerServiceAsync {

	void getOffersFor(Customer customer, AsyncCallback<List<Offer>> callback);

}
