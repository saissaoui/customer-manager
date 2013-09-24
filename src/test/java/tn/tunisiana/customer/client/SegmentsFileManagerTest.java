package tn.tunisiana.customer.client;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.shared.model.Segment;
import tn.tunisiana.customer.util.SegmentsFileManager;

public class SegmentsFileManagerTest {
	SegmentsFileManager sfm;
	Segment segment;

	@Before
	public void setUp() throws Exception {
		sfm = new SegmentsFileManager();
	}

	// @Test
	public void testReadSegment() {
		segment = sfm.readSegment(1);
		assertTrue(segment.getIdSegment() == 1);
	}

	@Test
	public void testSaveSegment() {
		Segment segment = sfm.readSegment(1);
		segment.setIdSegment(2);
		sfm.saveSegment(segment);

	}

}
