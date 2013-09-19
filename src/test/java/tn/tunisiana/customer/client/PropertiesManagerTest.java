package tn.tunisiana.customer.client;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import tn.tunisiana.customer.shared.model.Offer;
import tn.tunisiana.customer.shared.model.Segment;
import tn.tunisiana.customer.util.PropertiesManager;

public class PropertiesManagerTest {

	@Test
	public void testReadSegment() {

		Hashtable<String, Integer> coresp = PropertiesManager.readSegment(1);

		assertNotNull(coresp);
		assertTrue(coresp.size() > 0);

	}

	@Test
	public void testWriteSegment() {
		Segment segment = new Segment();
		segment.setIdSegment(3);
		segment.setCritere("distance");
		Offer offer = new Offer();
		Offer offer2 = new Offer();

		offer.setIdoffer(1);
		offer2.setIdoffer(2);
		Hashtable<String, Offer> coresp = new Hashtable<String, Offer>();

		coresp.put("50", offer);
		coresp.put("100", offer2);
		segment.setCorrespondances(coresp);
		PropertiesManager.writeSegment(segment);
		assertTrue(true);
	}

}
