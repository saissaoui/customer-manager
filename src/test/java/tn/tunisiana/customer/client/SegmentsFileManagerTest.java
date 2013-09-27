package tn.tunisiana.customer.client;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.server.model.Segment;
import tn.tunisiana.customer.util.SegmentsFileManager;

public class SegmentsFileManagerTest {
	SegmentsFileManager sfm;
	Segment segment;

	@Before
	public void setUp() throws Exception {
		sfm = new SegmentsFileManager();
	}

	@Test
	public void testReadSegment() {

		// assertTrue(sfm.getAllSegments().size() == 2);
	}

	@Test
	public void testSaveSegment() {
		segment = new Segment();
		segment.setIdSegment(23);
		sfm.saveSegment(segment);

	}

}
