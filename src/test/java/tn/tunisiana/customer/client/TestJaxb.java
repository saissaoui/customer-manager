package tn.tunisiana.customer.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import tn.tunisiana.customer.server.model.Segment;

public class TestJaxb {

	//@Test
	public void test() {

		File file = new File("segments/segment1.xml");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Segment.class);

			Unmarshaller jaxbUnmarshaller;
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Segment segment = (Segment) jaxbUnmarshaller.unmarshal(file);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(segment, System.out);

			assertNotNull(segment);
			assertTrue(segment.getIdSegment() == 1);
		} catch (JAXBException e) {

			e.printStackTrace();
			fail("exception");
		}

	}

}
