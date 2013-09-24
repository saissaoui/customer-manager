package tn.tunisiana.customer.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import tn.tunisiana.customer.shared.model.Offer;
import tn.tunisiana.customer.shared.model.Segment;
import tn.tunisiana.customer.util.PropertiesManager;

public class PropertiesManagerTest {

	@Test
	public void testReadSegment() {

	//	Hashtable<List<String>, Integer> coresp = PropertiesManager.readSegment(3);
//
//		assertNotNull(coresp);
//		assertTrue(coresp.size() > 0);

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
		Hashtable<List<String>, Integer> coresp = new Hashtable<List<String>, Integer>();

		List<String> list = new ArrayList<String>();
		
		list.add( ">100");
		list.add( "<200");
		coresp.put(list, offer.getIdoffer());
		
		//segment.setCorrespondances(coresp);
		//PropertiesManager.writeSegment(segment);
		assertTrue(true);
	}

}
