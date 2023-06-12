package it.betacom.dao;

import java.util.List;

import it.betacom.model.Editore;

public interface EditoreDao {

	List<Editore> getAllEdi();
	Editore getEdiById(int codiceE);
	void insertEdi(int codiceE,String nome);
	void insnewEdi(Editore editore);
	void delnewEdi(Editore editore);
	void updnewEdi(Editore editore);
	void deleteEdi(int codiceE);
	void updateEdi(int codiceE,String nome,int pk);
	
}
