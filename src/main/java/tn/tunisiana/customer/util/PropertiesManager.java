package tn.tunisiana.customer.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


import tn.tunisiana.customer.shared.model.Offer;
import tn.tunisiana.customer.shared.model.Segment;

public class PropertiesManager {
	static Properties properties = new Properties();

	public static Hashtable<String, Integer> readSegment(int segmentId) {

		try {
			// load a properties file
			properties.load(new FileInputStream("segments/" + segmentId
					+ ".properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		Hashtable<String, Integer> h =new Hashtable<String, Integer>();
		
		
		for(Entry<Object, Object> entry: properties.entrySet())
		{
			h.put(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString()));
		
			
		}

		return h;
	}

	public static void writeSegment(Segment segment) {

		for (String key : segment.getCorrespondances().keySet())
			properties.setProperty(key,
					(segment.getCorrespondances().get(key).getIdoffer()) + "");

		try {
			properties.store(
					new FileOutputStream("segments/" + segment.getIdSegment()
							+ ".properties"), null);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
