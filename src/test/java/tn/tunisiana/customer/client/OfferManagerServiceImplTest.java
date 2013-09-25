package tn.tunisiana.customer.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.server.services.OfferManagerServiceImpl;
import tn.tunisiana.customer.shared.model.Customer;

public class OfferManagerServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		IOfferManagerService oms = new OfferManagerServiceImpl();
		Customer customer = new Customer();
		customer.setAge(30);

		assertTrue(oms.getOffersFor(customer).size() != 0);
	}

}
