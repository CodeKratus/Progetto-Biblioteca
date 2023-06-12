package it.betacom.test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.JdbcRowSetImpl;
import it.betacom.model.DbHandler2;




public class EsempioRowSet {

	public static void main(String[] args) {
		 try {
			 ////////////////////////////JDBCROWSETFACTORY
			 
			 RowSetFactory rsf = RowSetProvider.newFactory();
			 JdbcRowSet jrs = rsf.createJdbcRowSet();
			 jrs.setUrl("jdbc:MySQL://localhost:3306/archivio");
			 jrs.setUsername("root");
			 jrs.setPassword("Justenioreh97!");
			 jrs.setCommand("Select * from genere");
			 jrs.execute(); 
			 while(jrs.next()) {
					System.out.print(jrs.getInt("CodiceG")+ " | ");
					System.out.println(jrs.getString("descrizione"));
			 }
			 
			 
			 
			 
			 ////////////////////////JDBCROWSET CONNECTION
		 
			 String sql = "Select * from genere";
		 Connection c =	DbHandler2.getInstance().getConnection();
		 PreparedStatement p = c.prepareStatement(sql);
		 ResultSet s = p.executeQuery();
			JdbcRowSet rs = new JdbcRowSetImpl(s);
			while(rs.next()) {
				
				System.out.print(rs.getInt("CodiceG")+ " | ");
				System.out.println(rs.getString("descrizione"));
			}
			rs.close();
			
			///////////////////////////CachedRowSet 
			
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.setUrl("jdbc:MySQL://localhost:3306/archivio");
			crs.setUsername("root");
			crs.setPassword("Justenioreh97!");
			crs.setCommand("Select * from genere");
			crs.execute();
			while(crs.next()) {
				System.out.print(crs.getInt("CodiceG")+ " | ");
				System.out.println(crs.getString("descrizione"));
			}
			
			
			////////////////////WebRowSet
			
			WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
			wrs.setUrl("jdbc:MySQL://localhost:3306/archivio");
			wrs.setUsername("root");
			wrs.setPassword("Justenioreh97!");
			wrs.setCommand("Select * from genere");
			wrs.execute();
			FileOutputStream stream = new FileOutputStream("genere.xml");
			wrs.writeXml(stream);
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
