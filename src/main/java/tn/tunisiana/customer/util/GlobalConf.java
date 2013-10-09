package tn.tunisiana.customer.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

public class GlobalConf {
	static Properties properties = new Properties();
	private static String localisation;
	static {
		try {
			System.out.println(System.getProperty("user.dir"));
			properties.load(new FileInputStream("conf\\global.properties"));

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

	public static List<String> getGouvernorats() {
		File gouvs = new File("conf\\gouvern.txt");
		List<String> gouvsList = null;
		try {
			gouvsList = Files.readAllLines(gouvs.toPath(),
					Charset.defaultCharset());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gouvsList;
	}

}
