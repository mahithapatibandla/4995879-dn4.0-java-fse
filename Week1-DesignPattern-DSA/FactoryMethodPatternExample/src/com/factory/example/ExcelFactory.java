package com.factory.example;

public class ExcelFactory extends DocumentFactory{
	@Override
	public Document createDocument() {
		return new ExcelDocument();
	}
}
