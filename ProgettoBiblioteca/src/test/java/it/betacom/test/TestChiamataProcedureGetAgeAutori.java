package it.betacom.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.betacom.model.Autore;
import it.betacom.model.DbHandler;
import it.betacom.model.DbHandler2;

public class TestChiamataProcedureGetAgeAutori {
	static final String PROCEDURE = "call get_age_autori_nazione(?)";

	public static void main(String[] args) {
	
		try {
		
		ArrayList<Autore> li = new ArrayList<Autore>();
		
		Connection c;
	    c = DbHandler.getInstance().getConnection();
         CallableStatement cs = c.prepareCall(PROCEDURE);
         cs.setString(1, "Italia");
         ResultSet rs = cs.executeQuery();
         while(rs.next()) {
        	 
        	 
        	 li.add(new Autore(rs.getString("nome"), rs.getInt("eta")));
        	 
        	 
         }
         
         
         System.out.println(li);
     	c.close();
		rs.close();
		cs.close();
				        DbHandler.getInstance().closeConnection();
         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
