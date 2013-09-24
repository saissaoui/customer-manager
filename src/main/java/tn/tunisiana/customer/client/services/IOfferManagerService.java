package tn.tunisiana.customer.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import tn.tunisiana.customer.shared.model.Customer;
import tn.tunisiana.customer.shared.model.Offer;

@RemoteServiceRelativePath("oManagerService")
public interface IOfferManagerService  extends RemoteService{

	public List<Offer> getOffersFor(Customer customer);

}
