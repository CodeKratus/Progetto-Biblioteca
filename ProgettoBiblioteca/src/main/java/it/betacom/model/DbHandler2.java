package it.betacom.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbHandler2 {

	private static DbHandler2 single_instance = null;
	private Connection con;
	private final String URL = "jdbc:MySQL://localhost:3306/archivio";
	private final String USER = "root";
	private final String PASS = "Justenioreh97!";
	private final Properties connProp = new Properties();

	private DbHandler2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql.cj.jdbc.Driver non trovato");
			return;
		}
		System.out.println("MySQL Driver registrato correttamente!!");
		connProp.setProperty("user", USER);
		connProp.setProperty("password", PASS);

	}

	public Connection getConnection() {
     try {

			setCon(DriverManager.getConnection(URL, connProp));
//			   con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/archivio" , USER,PASS);
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

	public static DbHandler2 getInstance()  {
		if (single_instance == null) {
			single_instance = new DbHandler2();
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
	

