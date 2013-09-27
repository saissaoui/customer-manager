package tn.tunisiana.customer.client;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.server.services.OfferManagerServiceImpl;
import tn.tunisiana.customer.shared.model.CustomerDto;

public class OfferManagerServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		IOfferManagerService oms = new OfferManagerServiceImpl();
		CustomerDto customer = new CustomerDto();
		customer.setAge(30);

		assertTrue(oms.getOffersFor(customer).size() != 0);
	}

}
