package com;

public class Logger {
	//inside the class creating private static instance for the same class
			private static Logger instance;
			//private constructor should be created
			private Logger() {
				
			}
			//defining the public static method
			public static Logger getInstance() {
				if(instance==null) {
					instance=new Logger();
				}
				return instance;
			}
			public void display(String msg) {
				System.out.println("Message is : "+msg);
			}
}
