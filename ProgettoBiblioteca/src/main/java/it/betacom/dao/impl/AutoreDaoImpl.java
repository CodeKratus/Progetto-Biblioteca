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

import it.betacom.dao.AutoreDao;
import it.betacom.model.Autore;
import it.betacom.model.DbHandler;


public class AutoreDaoImpl implements AutoreDao{
	
	
	private List<Autore> autore;
	
	public AutoreDaoImpl() {
		autore = new ArrayList<Autore>();
	}
	
	@Override
	public List<Autore> getAll() {
System.out.println("///////////////////////");
		
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM autore");
			
			while(rs.next()) {
				///QUA HO DOVUTO GESTIRE L'ECCEZIONE PER GLI AUTORI NON MORTI
				//NB: GLI AUTORI NON MORTI HANNO COME VALORE DATE NULL!!
				//SICCOME CONVERTO L SQL DATE CHE PRENDO DAL DB IN LOCALDATE IL TOLOCALDATE VA IN ECCEZIONE QUANDO GLI VIENE PASSATO UN VALORE NULL
				//DI CONSEGUENZA GESTISCO IL TUTTO CON UN IF CHE DICE CHE SE IL VALORE PASSATO DAL DB è NULL ALLORA NON LO CONVERTO MA ASSEGNO 
				//DIRETTAMENTE AL localDateM = null COSI NON MI VA IN ECCEZIONE E STAMPA TUTTO SENZA PROBLEMI
				Date sqlDateN = rs.getDate("annoN");
				LocalDate localDateN = sqlDateN.toLocalDate();
				Date sqlDateM = rs.getDate("annoM");
				LocalDate localDateM = null;
				if(sqlDateM == null) {
					localDateM  = null;
				}else {
					localDateM  = sqlDateM.toLocalDate();
					}
			
				
				autore.add(new Autore(rs.getInt("codiceA"),rs.getString("nomeA"),localDateN,localDateM ,rs.getString("sesso"),rs.getString("nazione")));
				
			}
		
		  System.out.println(autore);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return autore;
	}

	@Override
	public Autore getAutById(int codiceA) {
		System.out.println("///////////////////////");
		Autore aut = null;
		Connection c;
		c = DbHandler.getInstance().getConnection();
		
		try {
			//uso prepareStatement perche gli passo un input
			PreparedStatement st = c.prepareStatement("SELECT * FROM autore where codiceA = ?");
			st.setInt(1, codiceA);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int codA = rs.getInt(1);
				String nomeA = rs.getString(2);
				Date sqlDateN = rs.getDate(3);
				LocalDate localDateN = sqlDateN.toLocalDate();
				Date sqlDateM = rs.getDate(4);
				LocalDate localDateM = null;
				if(sqlDateM == null) {
					localDateM  = null;
				}else {
					localDateM  = sqlDateM.toLocalDate();
					}
			
				
             
				String sess = rs.getString(5);
				String naz = rs.getString(6);
				aut = new Autore(codA,nomeA,localDateN,localDateM,sess,naz);
			}
		 System.out.println(aut);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aut;
	}

	@Override
	public void insertAut(int codiceA, String nomeA, String annoN, String annoM, String sesso, String nazione) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO autore(codiceA,nomeA,annoN,annoM,sesso,nazione) values (?,?,?,?,?,?)");
			st.setInt(1, codiceA);
			st.setString(2,nomeA);
			st.setString(3, annoN);
			st.setString(4, annoM);
			st.setString(5,sesso);
			st.setString(6,nazione);
			
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
	public void deleteAut(int codiceA) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM autore WHERE codiceA =?");
			st.setInt(1, codiceA);
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
	public void updateAut(int codiceA, String nomeA, String annoN, String annoM,String sesso, String nazione, int pk) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE autore SET codiceA = ?,nomeA = ?,annoN = ?,annoM = ?,sesso =?,nazione =? WHERE codiceA = ?");
			st.setInt(1, codiceA);
			st.setString(2,nomeA);
			st.setString(3, annoN);
			st.setString(4, annoM);
			st.setString(5,sesso);
			st.setString(6,nazione);
			st.setInt(7,pk);
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
	public void insnewAut(Autore autore) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO autore(codiceA,nomeA,annoN,annoM,sesso,nazione) values (?,?,?,?,?,?)");
			st.setInt(1, autore.getCodiceA());
			st.setString(2,autore.getNomeA());
			st.setString(3, autore.getAnnoNT());
			st.setString(4, autore.getAnnoMT());
			st.setString(5,autore.getSesso());
			st.setString(6,autore.getNazione());
			
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
	public void updnewAut(Autore autore) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE autore SET codiceA = ?,nomeA = ?,annoN = ?,annoM = ?,sesso =?,nazione =? WHERE codiceA = ?");
			st.setInt(1, autore.getCodiceA());
			st.setString(2,autore.getNomeA());
			st.setString(3, autore.getAnnoNT());
			st.setString(4, autore.getAnnoMT());
			st.setString(5,autore.getSesso());
			st.setString(6,autore.getNazione());
			st.setInt(7,autore.getCodiceA());
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
	public void delnewAut(Autore autore) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM autore WHERE codiceA =?");
			st.setInt(1, autore.getCodiceA());
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
