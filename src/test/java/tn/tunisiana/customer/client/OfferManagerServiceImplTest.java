package tn.tunisiana.customer.client;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.server.services.OfferManagerServiceImpl;
import tn.tunisiana.customer.shared.model.CustomerDto;
import tn.tunisiana.customer.shared.model.OfferDto;

public class OfferManagerServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		IOfferManagerService oms = new OfferManagerServiceImpl();
		CustomerDto customer = new CustomerDto();
		customer.setAge(30);
		customer.setGouvernorat("Ben Arous");
		List<OfferDto> offres = oms.getOffersFor(customer);
		System.out.println("offres: " + offres.size());
		assertTrue(offres.size() != 0);
	}

}
