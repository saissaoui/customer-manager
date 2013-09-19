package tn.tunisiana.customer.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import tn.tunisiana.customer.shared.model.Offer;
import tn.tunisiana.customer.shared.model.Segment;

public class PropertiesManager {
	static Properties properties = new Properties();

	public static Hashtable<String, Offer> readSegment(String filePath) {

		return null;
	}

	 public static void writeSegment(Segment segment) {

		for (String key : segment.getCorrespondances().keySet())
			properties.setProperty(key,
					(segment.getCorrespondances().get(key).getIdoffer()) + "");

		try {
			properties.store(new FileOutputStream("segments/"+segment.getIdSegment()
					+ ".properties"), null);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
