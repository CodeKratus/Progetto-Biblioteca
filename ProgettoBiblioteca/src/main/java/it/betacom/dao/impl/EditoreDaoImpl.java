package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.EditoreDao;
import it.betacom.model.DbHandler;
import it.betacom.model.Editore;

public class EditoreDaoImpl implements EditoreDao{
	
	private List<Editore> editori;
	
	
	public EditoreDaoImpl() {
		editori = new ArrayList<Editore>();
	}
	
	@Override
	public List<Editore> getAllEdi() {
	System.out.println("///////////////////////");
		
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM editore");
			
			while(rs.next()) {
				editori.add(new Editore(rs.getInt("codiceE"),rs.getString("nome")));
				
			}
		
		  System.out.println(editori);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return editori;
	}

	@Override
	public Editore getEdiById(int codiceE) {
		System.out.println("///////////////////////");
		Editore edi = null;
		Connection c;
		c = DbHandler.getInstance().getConnection();
		
		try {
			//uso prepareStatement perche gli passo un input
			PreparedStatement st = c.prepareStatement("SELECT * FROM editore where codiceE = ?");
			st.setInt(1, codiceE);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int cod = rs.getInt(1);
				String nom = rs.getString(2);
				edi = new Editore(cod,nom);
			}
		 System.out.println(edi);
		  c.close();
		  st.close();
		  rs.close();
		  DbHandler.getInstance().closeConnection();
		  System.out.println("///////////////////////");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return edi;
	}

	@Override
	public void insertEdi(int codiceE, String nome) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO editore(codiceE,nome) values (?,?)");
			st.setInt(1, codiceE);
			st.setString(2,nome);
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
	public void deleteEdi(int codiceE) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM editore WHERE codiceE =?");
			st.setInt(1, codiceE);
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
	public void updateEdi(int codiceE, String nome, int pk) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE editore SET codiceE = ?,nome = ? WHERE codiceE = ?");
			st.setInt(1, codiceE);
			st.setString(2,nome);
			st.setInt(3,pk);
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
	public void insnewEdi(Editore editore) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("INSERT INTO editore(codiceE,nome) values (?,?)");
			st.setInt(1, editore.getCodiceE());
			st.setString(2,editore.getNome());
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
	public void delnewEdi(Editore editore) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("DELETE FROM editore WHERE codiceE =?");
			st.setInt(1, editore.getCodiceE());
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
	public void updnewEdi(Editore editore) {
		System.out.println("///////////////////////");
		Connection c;
		c = DbHandler.getInstance().getConnection();
		try {
			PreparedStatement st = c.prepareStatement("UPDATE editore SET codiceE = ?,nome = ? WHERE codiceE = ?");
			st.setInt(1, editore.getCodiceE());
			st.setString(2,editore.getNome());
			st.setInt(3,editore.getCodiceE());
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
