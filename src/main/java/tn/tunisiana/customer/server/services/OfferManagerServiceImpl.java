package tn.tunisiana.customer.server.services;

import java.util.ArrayList;
import java.util.List;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.server.business.SegmentTester;
import tn.tunisiana.customer.server.dao.impl.OfferDaoImpl;
import tn.tunisiana.customer.server.model.Customer;
import tn.tunisiana.customer.server.model.Offer;
import tn.tunisiana.customer.shared.model.CustomerDto;
import tn.tunisiana.customer.shared.model.OfferDto;
import tn.tunisiana.customer.util.GeoCalculator;
import tn.tunisiana.customer.util.GlobalConf;
import tn.tunisiana.customer.util.SegmentsFileManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class OfferManagerServiceImpl extends RemoteServiceServlet implements
		IOfferManagerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 597013903416774611L;
	private SegmentTester segTester = new SegmentTester();
	private SegmentsFileManager segFileMan = new SegmentsFileManager();
	private OfferDaoImpl odi = new OfferDaoImpl();

	public List<OfferDto> getOffersFor(CustomerDto customer) {
		
		GeoCalculator gc = new GeoCalculator();
		long distance = gc.distance(
				customer.getGouvernorat(), GlobalConf.getLocalisation());
		customer.setDistance(distance);

		if (segTester.getSegments() == null)
			segTester.setSegments(segFileMan.getAllSegments());
		List<Integer> offers = segTester.defineOffers(new Customer(customer));
		List<OfferDto> offerDtos = new ArrayList<OfferDto>();
		if (offers.size() != 0) {
			for (Offer offer : odi.listOffers(offers))

				offerDtos.add(createOfferDto(offer));

			return offerDtos;
		} else
			return null;
	}

	OfferDto createOfferDto(Offer offer) {
		return new OfferDto(offer.getIdoffer(), offer.getOfferName(),
				offer.getDescription());

	}

}
