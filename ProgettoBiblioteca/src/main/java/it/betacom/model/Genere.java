package it.betacom.model;

public class Genere {
	
	private String descrizione;
	private int codiceG;
	
	public Genere() {}
	
	public Genere(int codiceG ,String descrizione) {
		this.setCodiceG(codiceG);
		this.setDescrizione(descrizione);
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getCodiceG() {
		return codiceG;
	}
	public void setCodiceG(int codiceG) {
		this.codiceG = codiceG;
	}
	@Override
	public String toString() {
		return "ID : " + codiceG + " Genere : " + descrizione + "\n";
	}

}
