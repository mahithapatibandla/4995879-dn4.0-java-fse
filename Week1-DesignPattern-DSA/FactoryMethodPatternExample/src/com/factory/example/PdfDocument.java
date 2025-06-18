package com.factory.example;

public class PdfDocument implements Document {
	@Override
	//here we have used the method from document interface with initialization
	public void opendoc() {
		System.out.println("Welcome to the PDF document!!");
	}
}
