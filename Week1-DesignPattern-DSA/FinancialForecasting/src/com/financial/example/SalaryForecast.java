package com.financial.example;
import java.util.*;
	public class SalaryForecast {
	public static double financialForecast(double currsalary,double increment,int years) {
		if(years==0) {
			return currsalary;
		}
		else {
			double newsal=currsalary*(1+increment);
			return financialForecast(newsal,increment,years-1);
		}
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		double currentsalary=sc.nextDouble();
		double incrementrate=sc.nextDouble();
		int years=sc.nextInt();
		double result=financialForecast(currentsalary,incrementrate,years);
		System.out.println("The salary after " + years + " years is: ₹" + String.format("%.2f", result));

	}
}
	
