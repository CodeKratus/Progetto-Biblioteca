package it.betacom.model;


import java.time.LocalDate;

public class Autore {

	private int codiceA;
	private String nomeA;
	private String annoNT;
	private String annoMT;
	private LocalDate annoN;
	private LocalDate annoM;
	private String sesso;
	private String nazione;
	private int eta;
	private String nome;
	
	public Autore(String nome,int eta) {
		this.setNome(nome);
		this.setEta(eta);
		
	}

	
	public Autore(int codiceA,String nomeA,String annoNT,String annoMT,String sesso,String nazione) {
	this.codiceA=codiceA;
	this.nomeA=nomeA;
	this.annoNT=annoNT;
	this.annoMT=annoMT;
	this.annoN = LocalDate.parse(annoNT);
	this.annoM = LocalDate.parse(annoMT);
	this.sesso=sesso;
	this.nazione=nazione;
	}
	
	public Autore(int codiceA,String nomeA,LocalDate annoN,LocalDate annoM,String sesso,String nazione) {
		this.codiceA=codiceA;
		this.nomeA=nomeA;
		this.annoN=annoN;
		this.annoM=annoM;
		this.sesso=sesso;
		this.nazione=nazione;
		}
	
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodiceA() {
		return codiceA;
	}


	public void setCodiceA(int codiceA) {
		this.codiceA = codiceA;
	}


	public String getNomeA() {
		return nomeA;
	}


	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}


	public String getAnnoNT() {
		return annoNT;
	}


	public void setAnnoNT(String annoN) {
		this.annoNT = annoN;
	}


	public String getAnnoMT() {
		return annoMT;
	}


	public void setAnnoMT(String annoM) {
		this.annoMT = annoM;
	}


	public String getSesso() {
		return sesso;
	}


	public void setSesso(String sesso) {
		this.sesso = sesso;
	}


	public String getNazione() {
		return nazione;
	}


	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	@Override
	public String toString() {
		return "Autore : " + codiceA + "  nomeA : " + nomeA + " annoN : " + annoN + " annoM : " + annoM + " sesso : "
				+ sesso + " nazione : " + nazione + "\n";
	}


	public  LocalDate getAnnoN() {
		return annoN;
	}


	public  void setAnnoN(LocalDate annoN) {
		this.annoN = annoN;
	}


	public  LocalDate getAnnoM() {
		return annoM;
	}


	public  void setAnnoM(LocalDate annoM) {
		this.annoM = annoM;
	}
	
	
	

	
	
	
}
