package tn.tunisiana.customer.client;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tn.tunisiana.customer.util.GlobalConf;

public class GlobalConfTest {

	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetLocalisation() {
		String local = GlobalConf.getLocalisation();
		boolean ass= local.equals("Tunis");
	assertTrue(ass);	
	}

	//@Test
	public void testSaveConf() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGouvernorats() {
		List<String> gouvs =GlobalConf.getGouvernorats();
		
		assertTrue(gouvs.size()==24);
	}

}
