package com;
import java.util.*;
public class Logging {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String message=sc.nextLine();
		//here directly we can't create object for the Logger beacause we have intialized it with private variable
		Logger l=Logger.getInstance();
		l.display(message);
		String xyz="Hello Cognizant!!";
		Logger m=Logger.getInstance();
		m.display(xyz);
		
		
		}
}
