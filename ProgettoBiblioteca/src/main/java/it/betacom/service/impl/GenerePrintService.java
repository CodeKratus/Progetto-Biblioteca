package it.betacom.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import it.betacom.dao.GenereDao;
import it.betacom.dao.impl.GenereDaoImpl;
import it.betacom.model.Genere;
import it.betacom.model.LeggiConfig;
import it.betacom.service.PrintService;

public class GenerePrintService<T> implements PrintService<T>{
	private String path = LeggiConfig.getInstance().getPath();
	@Override
	public void saveListAsTxt() {
	GenereDao g = new GenereDaoImpl();
	List<Genere> temp = g.getAllGen();
	BufferedWriter writer;
	try {
		writer = new BufferedWriter(new FileWriter(new File(path + "/ListaGenere.txt")));
	//for(String r: entry) {
		writer.write(temp.toString());
	    writer.newLine();
		writer.flush();
        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveListAsPdf() {
		GenereDao g = new GenereDaoImpl();
		List<Genere> temp = g.getAllGen();
		 Document document = new Document();
		OutputStream out;
		try {
			out = new FileOutputStream(new File(path + "/ListaGenere.pdf"));
		    PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph(temp.toString() + "\n"));	 
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	@Override
	public void saveListAsCsv() {
		 try {
				CSVWriter writer = new CSVWriter(new FileWriter(path + "/ListaGenere.csv"));
				GenereDao a = new GenereDaoImpl();
				List<Genere> temp = a.getAllGen();
				List<String[]> data = new ArrayList<String[]>();
				data.add(new String[] { "codiceG", "descrizione"});
				data.add(new String[] {temp.toString()});
				writer.writeAll(data);
				writer.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		
	}

	@Override
	public void saveAsTxt(T t) {
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(new File(path + "/Genere.txt")));
			writer.write(t.toString());
		    writer.newLine();
			writer.flush();
	        writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void saveAsPdf(T t) {
		 Document document = new Document();
			OutputStream out;
			try {
				out = new FileOutputStream(new File(path + "/Genere.pdf"));
			    PdfWriter.getInstance(document, out);
				document.open();
				document.add(new Paragraph(t.toString() + "\n"));	 
				document.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void saveAsCsv(T t) {
		 try {
				CSVWriter writer = new CSVWriter(new FileWriter(path + "/Genere.csv"));
				List<String[]> data = new ArrayList<String[]>();
				data.add(new String[] { "codiceG", "descrizione"});
				data.add(new String[] {t.toString()});
				writer.writeAll(data);
				writer.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}

}
