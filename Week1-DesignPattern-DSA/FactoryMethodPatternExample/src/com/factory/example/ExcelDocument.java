package com.factory.example;

public class ExcelDocument implements Document {
	@Override
	//implemenation of method of interface
	public void opendoc() {
		System.out.println("Welcome to the Excel Document!!");
	}
}
