package it.betacom.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeggiConfig {
	private static LeggiConfig single_instance = null;
	private final Properties pathprop = new Properties();
	private final String PATH = "C:/config.properties";
	private String path;
	private LeggiConfig() {
		FileInputStream conf;
		try {
			conf = new FileInputStream(PATH);
            pathprop.load(conf);
			path = pathprop.getProperty("path");
			File directory = new File(path);
			if(!directory.exists()) {
				directory.mkdir();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public static LeggiConfig getInstance()  {
		if (single_instance == null) {
			single_instance = new LeggiConfig();
		}
		return single_instance;
	}




	public String getPath() {
		return path;
	}
}
