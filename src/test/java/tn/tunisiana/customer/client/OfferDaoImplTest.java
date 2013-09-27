package tn.tunisiana.customer.client;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.server.dao.impl.OfferDaoImpl;

public class OfferDaoImplTest {

	OfferDaoImpl odi;

	@Before
	public void setUp() throws Exception {

		odi = new OfferDaoImpl();
	}

	@Test
	public void testAddOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOffer() {
		fail("Not yet implemented");
	}

	@Test
	public void testListOffers() {

		List<Integer> offers = new ArrayList<Integer>();
		offers.add(1);
		offers.add(3);
		assertTrue(odi.listOffers(offers).size() == 2);
		assertTrue(odi.listOffers(null).size() == 3);
	}

}
