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
import it.betacom.service.PrintService;
import it.betacom.service.impl.AutorePrintService;
import it.betacom.service.impl.EditorePrintService;
import it.betacom.service.impl.GenerePrintService;
import it.betacom.service.impl.LibroPrintService;

public class Test3Dao {

	public static void main(String[] args) {
		////////////////// stampa gen txt pdf csv lista
	PrintService<Genere> g = new GenerePrintService<Genere>();
	g.saveListAsTxt();
	g.saveListAsPdf();
	g.saveListAsCsv();
	
	/////////////////// stampa gen txt pdf csv singolo
	GenereDao ge = new GenereDaoImpl();
	Genere gen = ge.getGenById(1);
	g.saveAsPdf(gen);
	g.saveAsTxt(gen);
	g.saveAsCsv(gen);
	
	
	//////////////////////// stampa edi txt pdf csv lista
	PrintService<Editore> e = new EditorePrintService<Editore>();
	e.saveListAsTxt();
	e.saveListAsPdf();
	e.saveListAsCsv();
	
	
	
	////////////////stampa edi txt pdf csv singolo
	EditoreDao ed = new EditoreDaoImpl();
	Editore edi = ed.getEdiById(1);
	e.saveAsTxt(edi);
	e.saveAsPdf(edi);
	e.saveAsCsv(edi);
	
	///////////////stampa aut txt pdf csv lista
	PrintService<Autore> a = new AutorePrintService<Autore>();
	a.saveListAsTxt();
	a.saveListAsPdf();
	a.saveListAsCsv();
	
	
	
////////////////stampa aut txt pdf csv singolo
	AutoreDao au = new AutoreDaoImpl();
	Autore aut = au.getAutById(1);
	a.saveAsTxt(aut);
	a.saveAsPdf(aut);
	a.saveAsCsv(aut);
	
	
	
	
	
/////////////stampa libro txt pdf csv lista
	
	PrintService<Libro> l = new LibroPrintService<Libro>();
	l.saveListAsTxt();
	l.saveListAsPdf();
	l.saveListAsCsv();
	
	
////////////////stampa libro txt pdf csv singolo
	LibroDao li = new LibroDaoImpl();
	Libro lib = li.getLibById(1);
	l.saveAsTxt(lib);
	l.saveAsPdf(lib);
	l.saveAsCsv(lib);
	
	
	
	
	
	

	}

}
