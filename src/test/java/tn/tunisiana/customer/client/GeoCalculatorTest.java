package tn.tunisiana.customer.client;

import static org.junit.Assert.*;

import org.junit.Test;

import tn.tunisiana.customer.util.GeoCalculator;

public class GeoCalculatorTest {

	@Test
	public void testDistance() {
		GeoCalculator geo = new GeoCalculator();

		Long distance = geo.distance("ben arous", "tunis");
		System.out.println(distance);
		assertTrue("zero", distance > 0);

	}

}
