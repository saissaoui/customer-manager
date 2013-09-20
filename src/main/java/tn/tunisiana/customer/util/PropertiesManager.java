package tn.tunisiana.customer.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import tn.tunisiana.customer.shared.model.Segment;

public class PropertiesManager {
	static Properties properties = new Properties();

	public static Hashtable<List<String>, Integer> readSegment(int segmentId) {

		try {
			// load a properties file
			properties.load(new FileInputStream("segments/" + segmentId
					+ ".properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		Hashtable<List<String>, Integer> h = new Hashtable<List<String>, Integer>();

		for (Entry<Object, Object> entry : properties.entrySet()) {
			h.put(conditionsParser(entry.getKey().toString()),
					Integer.parseInt(entry.getValue().toString()));

		}

		return h;
	}

	public static void writeSegment(Segment segment) {

		for (List<String> key : segment.getCorrespondances().keySet())
			properties.setProperty(conditionsEncoder(key),
					(segment.getCorrespondances().get(key)) + "");

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

	private static List<String> conditionsParser(String conditionsKey) {

		List<String> conditions = new ArrayList<String>();

		for (String cond : conditionsKey.split(";"))
			conditions.add(cond);

		return conditions;
	}

	private static String conditionsEncoder(List<String> conditions) {

		String conKey = "";
		for (String condition : conditions)
			conKey += condition + ";";

		return conKey;
	}
}
