package tn.tunisiana.customer.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tn.tunisiana.customer.server.business.SegmentTester;
import tn.tunisiana.customer.server.model.Customer;
import tn.tunisiana.customer.server.model.Segment;
import tn.tunisiana.customer.util.SegmentsFileManager;

public class SegmentTesterTest {

	@Test
	public void testDefineOffers() {
		
		SegmentsFileManager sfm = new  SegmentsFileManager();
		
		List<Segment> segs = new ArrayList<Segment>();
		//segs.add(sfm.readSegment(1));
		SegmentTester st = new SegmentTester();
		st.setSegments(segs);
		Customer cust = new Customer();
		cust.setAge(30);
		List<Integer> offers = st.defineOffers(cust);

		assertTrue(true);

		assertNotNull("fail", offers);
	}

}
