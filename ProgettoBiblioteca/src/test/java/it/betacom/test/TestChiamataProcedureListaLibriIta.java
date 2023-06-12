package it.betacom.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import it.betacom.model.DbHandler2;

public class TestChiamataProcedureListaLibriIta {
	static final String PROCEDURE = "call getLista_libri_autori_italiani()";
	public static void main(String[] args) {
		try {
			ArrayList<String> li = new ArrayList<String>();
		Connection c;
	    c = DbHandler2.getInstance().getConnection();
		CallableStatement cs = c.prepareCall(PROCEDURE);
		ResultSet rs = cs.executeQuery();
		while(rs.next()) {
	
			
			String[] lista = new String[] {"ID : " + rs.getString("CodiceL") +", Titolo : " + rs.getString("titolo")+  ", Autore : " + rs.getString("nomeA") + ", Genere : " + rs.getString("descrizione") + ", Editore : " + rs.getString("nome") + ", NumPag : " + rs.getInt("numPag") + ", A Pubblicazione : " + rs.getDate("anno") + "\n"};
   		    li.addAll(Arrays.asList(lista));
			
		}
			System.out.println(li);
		c.close();
		rs.close();
		cs.close();
		DbHandler2.getInstance().closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
