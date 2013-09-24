package tn.tunisiana.customer.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tn.tunisiana.customer.shared.model.Segment;

public class SegmentsFileManager {

	JAXBContext jaxbContext;

	public SegmentsFileManager() {
		try {
			jaxbContext = JAXBContext.newInstance(Segment.class);
		} catch (JAXBException e) {

			e.printStackTrace();
		}

	}

	public Segment readSegment(int segmentId) {

		Segment segment = null;
		File file = new File("segments/" + segmentId + ".xml");

		try {
			Unmarshaller jaxbUnmarshaller;
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			segment = (Segment) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {

			e.printStackTrace();

		}

		return segment;

	}

	public void saveSegment(Segment segment) {

		Marshaller jaxbMarshaller;
		try {
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(segment,
					new File("segments/" + segment.getIdSegment() + ".xml"));
		} catch (JAXBException e) {

			e.printStackTrace();
		}

	}

}
