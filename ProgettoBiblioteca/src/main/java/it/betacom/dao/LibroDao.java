package it.betacom.dao;

import java.util.List;

import it.betacom.model.Libro;

public interface LibroDao {
	List<Libro> getAll();
	Libro getLibById(int codiceL);
	void insertLib(int codiceL,String titolo, int numPag, String anno, int codiceA, int codiceG, int codiceE);
	void deleteLib(int codiceL);
	void updateLib(int codiceL,String titolo, int numPag, String anno, int codiceA, int codiceG, int codiceE,int pk);
	void insnewLib(Libro libro);
	void updnewLib(Libro libro);
	void delnewLib(Libro libro);
}
