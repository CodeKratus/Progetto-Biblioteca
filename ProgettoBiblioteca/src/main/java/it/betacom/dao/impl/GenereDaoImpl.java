package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.GenereDao;
import it.betacom.model.DbHandler;
import it.betacom.model.Genere;

public class GenereDaoImpl implements GenereDao{
	
	
	private List<Genere> generi;
	
	public GenereDaoImpl() {
		///istanzio l'arraylist altrimenti quando richiamo getAllGen dal main non mi arriva niente dal db
	    generi = new ArrayList<Genere>();
		//generi.add(new Genere(6 , "Avventura"));
		//generi.add(new Genere(7 , "Fantasy"));
		//generi.add(new Genere(8 , "Mistero"));
		
	}

	@Override
	public List<Genere> getAllGen() {
		System.out.println("///////////////////////");
		
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM genere");
			
			while(rs.next()) {
				generi.add(new Genere(rs.getInt("codiceG"),rs.getString("descrizione")));
				
			}
		
		  System.out.println(generi);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return generi;
	}

	@Override
	public Genere getGenById(int codiceG) {
		System.out.println("///////////////////////");
		Genere gen = null;
		Connection c;
		c = DbHandler.getInstance().getConnection();
		
		try {
			//uso prepareStatement perche gli passo un input
			PreparedStatement st = c.prepareStatement("SELECT * FROM genere where codiceG = ?");
			st.setInt(1, codiceG);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int cod = rs.getInt(1);
				String desc = rs.getString(2);
				gen = new Genere(cod,desc);
			}
		 System.out.println(gen);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gen;
	}

	@Override
	public void insertGen(int codiceG , String descrizione) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO genere(codiceG,descrizione) values (?,?)");
			st.setInt(1, codiceG);
			st.setString(2,descrizione);
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
	public void deleteGen(int codiceG) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM genere WHERE codiceG =?");
			st.setInt(1, codiceG);
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
	public void updateGen(int codiceG,String descrizione,int pk) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE genere SET codiceG = ?,descrizione = ? WHERE codiceG = ?");
			st.setInt(1, codiceG);
			st.setString(2,descrizione);
			st.setInt(3,codiceG);
			st.executeUpdate();
			System.out.println("Operazione di aggiornamento riuscita");
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
	public void insnewGen(Genere genere) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO genere(codiceG,descrizione) values (?,?)");
			st.setInt(1, genere.getCodiceG());
			st.setString(2,genere.getDescrizione());
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
	public void delnewGen(Genere genere) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM genere WHERE codiceG =?");
			st.setInt(1, genere.getCodiceG());
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
	public void updnewGen(Genere genere) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE genere SET codiceG = ?,descrizione = ? WHERE codiceG = ?");
			st.setInt(1, genere.getCodiceG());
			st.setString(2,genere.getDescrizione());
			st.setInt(3,genere.getCodiceG());
			st.executeUpdate();
			System.out.println("Operazione di aggiornamento riuscita");
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
