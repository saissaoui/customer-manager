package tn.tunisiana.customer.server.services;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.server.business.SegmentTester;
import tn.tunisiana.customer.server.dao.impl.OfferDaoImpl;
import tn.tunisiana.customer.shared.model.Customer;
import tn.tunisiana.customer.shared.model.Offer;

public class OfferManagerServiceImpl extends RemoteServiceServlet implements IOfferManagerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 597013903416774611L;
	private SegmentTester segTester = new SegmentTester();
	private OfferDaoImpl odi = new OfferDaoImpl();

	public List<Offer> getOffersFor(Customer customer) {

		List<Integer> offers = segTester.defineOffers(customer);

		if (offers.size() != 0)
			return odi.listOffers(offers);
		else
			return null;
	}

}
