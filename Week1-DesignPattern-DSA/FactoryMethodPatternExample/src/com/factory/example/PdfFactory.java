package com.factory.example;

public class PdfFactory extends DocumentFactory{
	//a class that extends abstract class methods with return type of interface
	@Override
	public Document createDocument() {
		return new PdfDocument();
	}
}
