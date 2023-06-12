package it.betacom.service;

public interface PrintService<T> {
void saveListAsTxt();
void saveListAsPdf();
void saveListAsCsv();
void saveAsTxt(T t);
void saveAsPdf(T t);
void saveAsCsv(T t);
}
