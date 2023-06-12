package it.betacom.model;

import java.time.LocalDate;

public class Libro {

	private String titolo;
	private String autore;
	private String genere;
	private String editore;
	private int numPag;
	private LocalDate annoS;
	private int id_libro;
	private int codiceL;
	private String anno;
	private int codiceA;
	private int codiceG;
	private int codiceE;
	private String nomeA;
	private String nomeG;
	private String nomeE;
	
    public Libro() {}
    
	public Libro(int id_libro,String titolo, String autore, String genere, String editore, int numPag, LocalDate annoS) {
		this.id_libro = id_libro;
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.editore = editore;
		this.numPag = numPag;
		this.annoS = annoS;
	}
	
	//creo nuovo costruttore per es 3 per convertire prima stringa in local date e successivamente nel main
	//convertire local date in sql date
	public Libro(String titolo, String autore, String genere, String editore, int numPag , String annoConv) {
		this.annoS = LocalDate.parse(annoConv);
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.editore = editore;
		this.numPag = numPag;
		
	}
	public Libro(int codiceL,String titolo, int numPag, String anno, int codiceA, int codiceG, int codiceE) {
	     this.codiceL=codiceL;
	     this.anno=anno;
	     this.annoS = LocalDate.parse(anno);
		this.titolo = titolo;
		this.numPag = numPag;
		this.codiceA=codiceA;
		this.codiceG=codiceG;
		this.codiceE=codiceE;
		
		
	}
	
	public Libro(int codiceL,String titolo, int numPag, String anno, String nomeA, String nomeG, String nomeE) {
	     this.codiceL=codiceL;
	     this.anno=anno;
	     this.annoS = LocalDate.parse(anno);
		this.titolo = titolo;
		this.numPag = numPag;
		this.nomeA=nomeA;
		this.nomeG=nomeG;
		this.nomeE=nomeE;
	
		
		
	}
	public Libro(int codiceL,String titolo, int numPag, LocalDate annoS, String nomeA, String nomeG, String nomeE) {
	     this.codiceL=codiceL;
	     this.annoS = annoS;
		this.titolo = titolo;
		this.numPag = numPag;
		this.nomeA=nomeA;
		this.nomeG=nomeG;
		this.nomeE=nomeE;
	
		
		
	}
	public Libro(int codiceL,String titolo, int numPag, LocalDate annoS, int codiceA, int codiceG, int codiceE) {
	     this.codiceL=codiceL;
	     this.annoS = annoS;
		this.titolo = titolo;
		this.numPag = numPag;
		this.codiceA=codiceA;
		this.codiceG=codiceG;
		this.codiceE=codiceE;
		
		
	}
	
//	@Override
//	public String toString() {
//		return  "ID : " + id_libro + ", Titolo : " + titolo + ", Autore : " + autore + ", Genere : " + genere + ", Editore : "+ editore + ", NumPag : " + numPag + ", Anno Pub : " + annoS + "\n";
//
//	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public LocalDate getAnnoS() {
		return annoS;
	}

	public void setAnnoS(LocalDate annoS) {
		this.annoS = annoS;
	}


	public int getId_libro() {
		return id_libro;
	}


	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getCodiceL() {
		return codiceL;
	}

	public void setCodiceL(int codiceL) {
		this.codiceL = codiceL;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public int getCodiceA() {
		return codiceA;
	}

	public void setCodiceA(int codiceA) {
		this.codiceA = codiceA;
	}

	public int getCodiceG() {
		return codiceG;
	}

	public void setCodiceG(int codiceG) {
		this.codiceG = codiceG;
	}

	public int getCodiceE() {
		return codiceE;
	}

	public void setCodiceE(int codiceE) {
		this.codiceE = codiceE;
	}

	/*@Override
	public String toString() {
		return "codiceL : " + codiceL + " titolo : " + titolo + " numPag : " + numPag  + " anno : " + annoS
				+ " codiceA : " + codiceA + " codiceG : " + codiceG + " codiceE : " + codiceE + "\n";
	}*/
	
	@Override
	public String toString() {
		return "codiceL : " + codiceL + " titolo : " + titolo + " numPag : " + numPag  + " anno : " + annoS
				+ " Autore : " + nomeA + " Genere : " + nomeG + " Editore : " + nomeE + "\n";
	}

	public String getNomeA() {
		return nomeA;
	}

	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}

	public String getNomeG() {
		return nomeG;
	}

	public void setNomeG(String nomeG) {
		this.nomeG = nomeG;
	}

	public String getNomeE() {
		return nomeE;
	}

	public void setNomeE(String nomeE) {
		this.nomeE = nomeE;
	}
}
