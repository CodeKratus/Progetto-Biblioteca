package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.LibroDao;
import it.betacom.model.DbHandler;
import it.betacom.model.Libro;

public class LibroDaoImpl implements LibroDao{

	private List<Libro> libro;
	
	public LibroDaoImpl() {
		libro = new ArrayList<Libro>();
		
	}
	
	@Override
	public List<Libro> getAll() {
System.out.println("///////////////////////");
		
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT codiceL ,titolo , numPag ,anno,a.NomeA ,g.descrizione ,e.nome  FROM libro l \r\n"
					+ "join autore a on l.codiceA = a.codiceA \r\n"
					+ "join genere g on l.codiceG = g.codiceG \r\n"
					+ "join editore e on l.codiceE = e.codiceE order by codiceL");
			
			while(rs.next()) {
				//Date sqlDate = rs.getDate("anno");
				//LocalDate localDate = sqlDate.toLocalDate();
				//libro.add(new Libro(rs.getInt("codiceL"),rs.getString("titolo"),rs.getInt("numPag"),localDate,rs.getString("codiceA"),rs.getString("codiceG"),rs.getString("codiceE")));
				libro.add(new Libro(rs.getInt("codiceL"),rs.getString("titolo"),rs.getInt("numPag"),rs.getString("anno"),rs.getString("nomeA"),rs.getString("descrizione"),rs.getString("nome")));
				
			}
		
		  System.out.println(libro);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return libro;
		
	}

	@Override
	public Libro getLibById(int codiceL) {
		System.out.println("///////////////////////");
		Libro lib = null;
		Connection c;
		c = DbHandler.getInstance().getConnection();
		
		try {
			//uso prepareStatement perche gli passo un input
			/*PreparedStatement st = c.prepareStatement("SELECT * FROM libro where codiceL = ?");
			st.setInt(1, codiceL);
			ResultSet rs = st.executeQuery();*/
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT codiceL ,titolo , numPag ,anno,a.NomeA ,g.descrizione ,e.nome  FROM libro l \r\n"
					+ "join autore a on l.codiceA = a.codiceA \r\n"
					+ "join genere g on l.codiceG = g.codiceG \r\n"
					+ "join editore e on l.codiceE = e.codiceE order by codiceL");
			
			if(rs.next()) {
				int codL = rs.getInt(1);
				String titolo = rs.getString(2);
				int nPag = rs.getInt(3);
				Date sqlDate = rs.getDate(4);
				LocalDate localDate = sqlDate.toLocalDate();
				String autore = rs.getString(5);
				String genere = rs.getString(6);
				String editore = rs.getString(7);
				lib = new Libro(codL,titolo,nPag,localDate,autore,genere,editore);
				
				//int codA = rs.getInt(5);
				//int codG = rs.getInt(6);
				//int codE = rs.getInt(7);
				//lib = new Libro(codL,titolo,nPag,localDate,codA,codG,codE);
			}
		 System.out.println(lib);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lib;
	}

	@Override
	public void insertLib(int codiceL, String titolo, int numPag, String anno, int codiceA, int codiceG, int codiceE) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO libro(codiceL,titolo,numPag,anno,codiceA,codiceG,codiceE) values (?,?,?,?,?,?,?)");
			st.setInt(1, codiceL);
			st.setString(2,titolo);
			st.setInt(3, numPag);
			st.setString(4, anno);
			st.setInt(5,codiceA);
			st.setInt(6,codiceG);
			st.setInt(7,codiceE);
			
			st.executeUpdate();
			System.out.println("Operazione di inserimento riuscita");
			c.close();
			  st.close();
			  DbHandler.getInstance().closeConnection();
		System.out.println("///////////////////////");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteLib(int codiceL) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM libro WHERE codiceL =?");
			st.setInt(1, codiceL);
            st.executeUpdate();
			System.out.println("Operazione di eliminazione campo riuscita");
			c.close();
			  st.close();
			  DbHandler.getInstance().closeConnection();
				System.out.println("///////////////////////");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateLib(int codiceL, String titolo, int numPag, String anno, int codiceA, int codiceG, int codiceE,
			int pk) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE libro SET codiceL = ?,titolo = ?,numPag = ?,anno = ?,codiceA =?,codiceG =?,codiceE =? WHERE codiceL = ?");
			st.setInt(1, codiceL);
			st.setString(2,titolo);
			st.setInt(3, numPag);
			st.setString(4, anno);
			st.setInt(5,codiceA);
			st.setInt(6,codiceG);
			st.setInt(7,codiceE);
			st.setInt(8, pk);
			
			st.executeUpdate();
			System.out.println("Operazione di inserimento riuscita");
			c.close();
			  st.close();
			  DbHandler.getInstance().closeConnection();
		System.out.println("///////////////////////");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void insnewLib(Libro libro) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO libro(codiceL,titolo,numPag,anno,codiceA,codiceG,codiceE) values (?,?,?,?,?,?,?)");
			st.setInt(1, libro.getCodiceL());
			st.setString(2,libro.getTitolo());
			st.setInt(3, libro.getNumPag());
			st.setString(4, libro.getAnno());
			st.setInt(5,libro.getCodiceA());
			st.setInt(6,libro.getCodiceG());
			st.setInt(7,libro.getCodiceE());
			
			st.executeUpdate();
			System.out.println("Operazione di inserimento riuscita");
			c.close();
			  st.close();
			  DbHandler.getInstance().closeConnection();
		System.out.println("///////////////////////");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updnewLib(Libro libro) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE libro SET codiceL = ?,titolo = ?,numPag = ?,anno = ?,codiceA =?,codiceG =?,codiceE =? WHERE codiceL = ?");
			st.setInt(1, libro.getCodiceL());
			st.setString(2,libro.getTitolo());
			st.setInt(3, libro.getNumPag());
			st.setString(4, libro.getAnno());
			st.setInt(5,libro.getCodiceA());
			st.setInt(6,libro.getCodiceG());
			st.setInt(7,libro.getCodiceE());
			st.setInt(8, libro.getCodiceL());
			
			st.executeUpdate();
			System.out.println("Operazione di inserimento riuscita");
			c.close();
			  st.close();
			  DbHandler.getInstance().closeConnection();
		System.out.println("///////////////////////");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delnewLib(Libro libro) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM libro WHERE codiceL =?");
			st.setInt(1, libro.getCodiceL());
            st.executeUpdate();
			System.out.println("Operazione di eliminazione campo riuscita");
			c.close();
			  st.close();
			  DbHandler.getInstance().closeConnection();
				System.out.println("///////////////////////");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
