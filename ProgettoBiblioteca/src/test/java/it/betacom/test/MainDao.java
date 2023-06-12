package it.betacom.test;



import it.betacom.dao.AutoreDao;
import it.betacom.dao.EditoreDao;
import it.betacom.dao.GenereDao;
import it.betacom.dao.LibroDao;
import it.betacom.dao.impl.AutoreDaoImpl;
import it.betacom.dao.impl.EditoreDaoImpl;
import it.betacom.dao.impl.GenereDaoImpl;
import it.betacom.dao.impl.LibroDaoImpl;
import it.betacom.model.Autore;
import it.betacom.model.Editore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;


public class MainDao {

	public static void main(String[] args) {
		
	      //GenereDao gd = new GenereDaoImpl();
		//Genere gene = new Genere(5,"Polizziiiaaaaa");
		//Richiamo la lista di generi del db
		//gd.getAllGen();
		//Richiamo il genere per id (praticamente where codiceG = id che gli passo)
		//gd.getGenById(1);
		//Inserisco il record nel genere (da errore se provo ad inserire ad un id gia occupato!!)
		//gd.insertGen(5,"Fantasy");
		//Aggiorno il record nel genere
		//gd.updateGen(5,"Poliziesco",5);
		//elimino il record nel genere 
		//gd.deleteGen(5);
		//gd.insnewGen(gene);
		//gd.updnewGen(gene);
		//gd.delnewGen(gene);
		
//		EditoreDao ed = new EditoreDaoImpl();
//		Editore edi = new Editore(7,"Trecciani");
//		//ed.getAllEdi();
//		ed.getEdiById(1);
//		//ed.insertEdi(3,"Laterza" );
//		//ed.insertEdi(4,"DeAgostini" );
//		//ed.insertEdi(5,"Bompiani" );
//		//ed.insertEdi(6,"Adelphi" );
//		ed.insertEdi(7,"Laquartaas" );
//		ed.updateEdi(7,"Cairo", 7);
//		ed.deleteEdi(7);
		
		//stesse operazioni ma passandogli un oggetto
//		ed.insnewEdi(edi);
//		ed.delnewEdi(edi);
//		ed.updnewEdi(edi);
		
	
		
		//AutoreDao ad = new AutoreDaoImpl();
		//Autore auto = new Autore(10,"Francesco","1950-10-20","2020-12-02","M","Italia");
		//ad.getAll();
		//ad.getEdiById(1);
		//ad.insertAut(10, "Carciof","1992-10-22" ,null,"M","Italia");
		//ad.updateAut(10, "FratmCarciof", "1992-10-22", "2023-03-17", "M", "Italia", 10);
		//ad.deleteAut(10);
		//ad.insnewAut(auto);
		//ad.updnewAut(auto);
		//ad.delnewAut(auto);
		
		
		
		LibroDao li = new LibroDaoImpl();
		Libro libro = new Libro(21,"Andar per cantine",250,"1890-08-15",1,2,2);
		//li.getAll();
		//li.getLibById(1);
		//li.insertLib(21, "La grande bibbia", 300,"1992-12-23", 1, 2, 4);
		//li.updateLib(21, "Adelchi", 496, "1822-10-01", 1, 2, 1, 21);
		//li.deleteLib(21);
		li.insnewLib(libro);
		//li.updnewLib(libro);
		//li.delnewLib(libro);
		
		
		
		
		
	/*	try {
	   ArrayList<Genere> li = new ArrayList<Genere>();

		Connection c;
		c = DbHandler.getInstance().getConnection();
		Statement stmt = c.createStatement();
       ResultSet rs = stmt.executeQuery(QUERY);
       
       GenereDao ge = new GenereDaoImpl();
	   
	  
       
       while(rs.next()) {
    	
    	   Genere g = new Genere(rs.getInt("codiceG"),rs.getString("descrizione"));
    	  
    	 
    	   }
       System.out.println( ge.getAllGen());
       //
      
       
       
       
       */
       
          
  
		
	/*	
		//implemento gendaoimpl
		GenereDao genDao = new GenereDaoImpl();
		//stampa generi 
		System.out.println("///////////////////////");
		for (Genere gen : genDao.getAllGen()) {
			System.out.println("ID :" + gen.getCodiceG() + " Genere : " + gen.getDescrizione());
		}
		
		//stampa dati genere richiesto
		System.out.println("///////////////////////");
		System.out.println("Prendo genere prima :");
		System.out.println(genDao.getGenById(0));
		
		
		//inserisci genere
		System.out.println("///////////////////////");
	    genDao.insertGen(new Genere(9,"Poliziesco"));
	    System.out.println("Genere aggiunto : ");
		for (Genere gen : genDao.getAllGen()) {
			
			System.out.println("ID :" + gen.getCodiceG() + " Genere : " + gen.getDescrizione());
		}
		
		//aggiorna genere
		
		
		System.out.println("///////////////////////");
		Genere up = genDao.getAllGen().get(0);
		System.out.println(up + " Aggiornato a : ");
		up.setDescrizione("Avventuroso");
		System.out.println(genDao.getGenById(0));
		
		//cancella
		System.out.println("///////////////////////");
		System.out.println(" Genere da eliminare : ");
		Genere del = genDao.getAllGen().get(3);
		System.out.println(del);
		genDao.deleteGen(del);
		System.out.println(" Genere eliminato : ");
        for (Genere gen : genDao.getAllGen()) {
			
			System.out.println("ID :" + gen.getCodiceG() + " Genere : " + gen.getDescrizione());
		}

		
		*/
		
		
	}

}
