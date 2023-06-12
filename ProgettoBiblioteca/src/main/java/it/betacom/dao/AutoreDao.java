package it.betacom.dao;

import java.util.List;

import it.betacom.model.Autore;


public interface AutoreDao {
	List<Autore> getAll();
	Autore getAutById(int codiceA);
	void deleteAut(int codiceA);
	void updateAut(int codiceA,String nomeA,String annoN,String annoM,String sesso,String nazione,int pk);
	void insertAut(int codiceA, String nomeA, String annoN, String annoM, String sesso, String nazione);
	void insnewAut(Autore autore);
	void updnewAut(Autore autore);
	void delnewAut(Autore autore);
}
