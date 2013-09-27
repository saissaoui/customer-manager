package tn.tunisiana.customer.client.services;

import java.util.List;

import tn.tunisiana.customer.shared.model.CustomerDto;
import tn.tunisiana.customer.shared.model.OfferDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IOfferManagerServiceAsync {

	void getOffersFor(CustomerDto customer, AsyncCallback<List<OfferDto>> callback);

}
