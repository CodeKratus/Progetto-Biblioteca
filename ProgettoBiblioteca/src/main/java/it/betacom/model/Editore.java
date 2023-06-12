package it.betacom.model;

public class Editore {

	private int codiceE;
	private String nome;
	
	
	 public Editore(int codiceE,String nome) {
		 this.setCodiceE(codiceE);
		 this.setNome(nome);
		 
	 }


	public int getCodiceE() {
		return codiceE;
	}


	public void setCodiceE(int codiceE) {
		this.codiceE = codiceE;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "ID : " + codiceE + " Nome : " + nome + "\n";
	}
	
	
	
	
}
