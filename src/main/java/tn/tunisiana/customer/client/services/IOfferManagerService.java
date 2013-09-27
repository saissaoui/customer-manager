package tn.tunisiana.customer.client.services;

import java.util.List;

import tn.tunisiana.customer.shared.model.CustomerDto;
import tn.tunisiana.customer.shared.model.OfferDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("oManagerService")
public interface IOfferManagerService extends RemoteService {

	public List<OfferDto> getOffersFor(CustomerDto customer);

}
