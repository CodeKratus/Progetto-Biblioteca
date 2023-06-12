package it.betacom.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbHandler {
	private static DbHandler single_instance = null;
	private Connection con;
	private final String PATH = "C:/filexjava/config.properties";
	private final Properties connProp = new Properties();
	private String url;
//	private String us;
//	private String pass;
	private DbHandler() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql.cj.jdbc.Driver non trovato");
			return;
		}
		System.out.println("MySQL Driver registrato correttamente!!");
		//prendo i prop dal file config
		FileInputStream is;
		try {
			is = new FileInputStream(PATH);
			
			//li carico
			
			connProp.load(is);
		
		} catch (IOException ex) {
			
			
			ex.printStackTrace();
		}
		
			//prendo l'url dal file config
	    url = connProp.getProperty("url");
	    //funziona con tutti e due i metodi
	    
	    //prendo user e pass dal file config
	    
//		 us = connProp.getProperty("user");
//	     pass = connProp.getProperty("pass");
	    
		connProp.setProperty("user", connProp.getProperty("user"));
		connProp.setProperty("password", connProp.getProperty("pass"));

	}

	public Connection getConnection() {
     try {
//funziona con tutti e due i metodi se decommento il prop sopra
//			setCon(DriverManager.getConnection(url, us, pass ));
    	 setCon(DriverManager.getConnection(url,connProp ));
			System.out.println("Connessione stabilita");
       } catch (SQLException e) {
			System.out.println("Connessione fallita");
            e.printStackTrace();	
		}
		return getCon();
	}

	public void closeConnection() {
		if (getCon() != null) {
			try {
				getCon().close();
				System.out.println("Connessione chiusa");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public static DbHandler getInstance()  {
		if (single_instance == null) {
			single_instance = new DbHandler();
		}
		return single_instance;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}

