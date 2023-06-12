package it.betacom.test;

import java.time.LocalDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.betacom.model.Libro;
import it.betacom.model.DbHandler2;

public class TestSelectAll {
	
	
	static final String PROCEDURE = "call crea_libro(?,?,?,?,?,?)";
	static final String QUERY3 = "select codiceL,titolo,nomeA,descrizione,nome ,numPag,anno from libro l join autore a "
			+ "on l.codiceA = a.CodiceA join genere g on l.codiceG = g.codiceG "
			+ "join editore e on l.codiceE = e.codiceE WHERE titolo = 'Odi2' and nomeA = 'Manzoni' order by codiceL";
	
	//QUERY ES 1 E ES 2
	static final String QUERY = "select codiceL,titolo,nomeA,descrizione,nome , numPag, anno from libro l join autore a "
			+ "on l.codiceA = a.CodiceA join genere g on l.codiceG = g.codiceG "
			+ "join editore e on l.codiceE = e.codiceE  order by codiceL";

	public static void main(String[] args) {
//		
//		//es 3
//		try {
//			ArrayList<Libro> li = new ArrayList<Libro>();
//		    Connection c;
//		    c = DbHandler.getInstance().getConnection();
//			CallableStatement cs = c.prepareCall(PROCEDURE);
//			Libro l = new Libro("Odi2","Manzoni","Romanzo","Rizzoli",267,"2010-10-12");
//			//converto l'anno che passo da localDate a sqlDate
//			 Date sqlDate = Date.valueOf(l.getAnnoS());
//			 cs.setString(1, l.getTitolo());
//		        cs.setString(2, l.getAutore());
//		        cs.setString(3, l.getGenere());
//		        cs.setString(4, l.getEditore());
//		        cs.setInt(5, l.getNumPag());
//		        cs.setDate(6, sqlDate);
//		        
//		        cs.execute();
//		        System.out.println("Operazione effettuata con successo!!");
//		  
//		        Statement stmt = c.createStatement();
//				ResultSet rs = stmt.executeQuery(QUERY3);
//				
//				
//				while (rs.next()) {
//					// converto sql date to localdate
//					Date sqlDate1 = rs.getDate("anno");
//					LocalDate localDate1 = sqlDate1.toLocalDate();
//			//puo dare errore di null della data se esagero con i campi in libro senza data!!!!!
//					
//					li.add(new Libro(rs.getInt("codiceL"), rs.getString("titolo"), rs.getString("nomeA"),
//							rs.getString("descrizione"), rs.getString("nome"), rs.getInt("numPag"), localDate1));
//	
//				}
//				System.out.println(li);
//			
//			stmt.close();
		//rs.close();
		//cs.close();
		//		        DbHandler.getInstance().closeConnection();
//		        
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	
		// Esercizio parte 2
//		Connection c;
//	ArrayList<Libro> li = new ArrayList<Libro>();
//
//		try {
//			c = DbHandler.getInstance().getConnection();
//			Statement stmt = c.createStatement();
//			ResultSet rs = stmt.executeQuery(QUERY);
//
//			while (rs.next()) {
//				// converto sql date to localdate
//				Date sqlDate = rs.getDate("anno");
//				LocalDate localDate1 = sqlDate.toLocalDate();
//				li.add(new Libro(rs.getInt("codiceL"), rs.getString("titolo"), rs.getString("nomeA"),
//						rs.getString("descrizione"), rs.getString("nome"), rs.getInt("numPag"), localDate1));
//
//		}
//
//			System.out.println(li);
//		//	stmt.close();
//		//	rs.close();
//			DbHandler.getInstance().closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

            //  Parte 1 esercizio
		//ArrayList<Libro> li = new ArrayList<Libro>();
		// APRI CONNESSIONE DB
		//try (Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/archivio", "root","Justenioreh97!");
		//		Statement stmt = conn.createStatement(); 
			//	ResultSet rs = stmt.executeQuery(QUERY);) 
	//	{
//			while (rs.next()) {
				//converto sql date to localdate
//				Date sqlDate = rs.getDate("anno");
//			LocalDate localDate1 = sqlDate.toLocalDate();
//				li.add(new Libro(rs.getInt("codiceL"),rs.getString("titolo"), rs.getString("nomeA"), rs.getString("descrizione"),
//						rs.getString("nome"), rs.getInt("numPag"), localDate1));
//	        		 String[] lista = new String[] {"Titolo : " + rs.getString("titolo")+  ", Autore : " + rs.getString("nomeA") + ", Genere : " + rs.getString("descrizione") + ", Editore : " + rs.getString("nome") + ", NumPag : " + rs.getString("numPag") + ", A Pubblicazione : " + rs.getString("anno") + "\n"};
//	        		 arList.addAll(Arrays.asList(lista));
			//}
//			try {
//				///// STAMPA A SCHERMO LISTA LIBRO
//				System.out.println(li);
//				///// CREA PDF CHE STAMPA LISTA LIBRO
//				Document document = new Document();
//				OutputStream out = new FileOutputStream(new File("C:/Querypdf.pdf"));
//				PdfWriter.getInstance(document, out);
//				document.open();
//				document.add(new Paragraph(li + "\n"));
////			 	 document.add(new Paragraph(arList.toString()+"\n"));
//				document.close();
//				out.close();
////           System.out.println(arList);
//				/////// CHIUDI CONNESSIONE DB
//				conn.close();
//			} catch (FileNotFoundException ex) {
//
//				ex.printStackTrace();
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		//} catch (SQLException e1) {

			//e1.printStackTrace();
		//}
//	}
}}
