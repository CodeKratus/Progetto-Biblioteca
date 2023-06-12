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
import it.betacom.dao.EditoreDao;
import it.betacom.dao.impl.EditoreDaoImpl;
import it.betacom.model.Editore;
import it.betacom.model.LeggiConfig;
import it.betacom.service.PrintService;

public class EditorePrintService<T> implements PrintService<T>{
	private String path = LeggiConfig.getInstance().getPath();

	@Override
	public void saveListAsTxt() {
		EditoreDao e = new EditoreDaoImpl();
		List<Editore> temp = e.getAllEdi();
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(new File(path + "/ListaEditori.txt")));
		//for(String r: entry) {
			writer.write(temp.toString());
		    writer.newLine();
			writer.flush();
	        writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	@Override
	public void saveListAsPdf() {
		EditoreDao e = new EditoreDaoImpl();
		List<Editore> temp = e.getAllEdi();
		 Document document = new Document();
		OutputStream out;
		try {
			out = new FileOutputStream(new File(path +"/ListaEditore.pdf"));
		    PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph(temp.toString() + "\n"));	 
			document.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
	}

	@Override
	public void saveListAsCsv() {
		 try {
			CSVWriter writer = new CSVWriter(new FileWriter(path + "/ListaEditore.csv"));
			EditoreDao a = new EditoreDaoImpl();
			List<Editore> temp = a.getAllEdi();
			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "codiceE", "nome"});
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
				writer = new BufferedWriter(new FileWriter(new File(path + "/Editore.txt")));
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
				out = new FileOutputStream(new File(path + "/Editore.pdf"));
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
			CSVWriter writer = new CSVWriter(new FileWriter(path + "/Editore.csv"));
			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "codiceE", "nome"});
			data.add(new String[] {t.toString()});
			writer.writeAll(data);
			writer.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		
	}



}
