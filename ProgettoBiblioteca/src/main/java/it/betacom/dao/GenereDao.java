package it.betacom.dao;

import it.betacom.model.Genere;
import java.util.List;

public interface GenereDao {
	List<Genere> getAllGen();
    Genere getGenById(int codiceG);
    void insertGen(int codiceG, String descrizione);
    void deleteGen(int codiceG);
    void updateGen(int codiceG, String descrizione,int pk);
    void insnewGen(Genere genere);
    void delnewGen(Genere genere);
    void updnewGen(Genere genere);
}
