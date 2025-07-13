package com.factory.example;

public class Test {
	public static void main(String args[]) {
		DocumentFactory wtype=new WordFactory();
		Document wordtype=wtype.createDocument();
		wordtype.opendoc();
		
		// for pdf 
		DocumentFactory ptype=new PdfFactory();
		Document pdftype=ptype.createDocument();
		pdftype.opendoc();
		
		//for excel
		DocumentFactory etype=new ExcelFactory();
		Document exceltype=etype.createDocument();
		exceltype.opendoc();
	}
}
