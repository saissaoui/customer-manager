package tn.tunisiana.customer.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalConf {
	static Properties properties = new Properties();
	private static String localisation;
	static {
		try {
			properties.load(new FileInputStream("conf/global.properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getLocalisation() {
		localisation = properties.getProperty("localisation");
		return localisation;
	}

	public void saveConf() {

		properties.setProperty("localisation", localisation);
	}

}
