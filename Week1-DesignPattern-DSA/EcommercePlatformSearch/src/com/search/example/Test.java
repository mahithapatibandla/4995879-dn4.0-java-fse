package com.search.example;
import java.util.*;
public class Test {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Product[] products = new Product[4];

        // First Product because i havent intialized the constructor 
		//through setters and getters 
        products[0] = new Product();
        products[0].setProductId(30133);
        products[0].setProductName("SMART PHONE");
        products[0].setCategory("ELECTRONICS");

        // Second Product
        products[1] = new Product();
        products[1].setProductId(30002);
        products[1].setProductName("AC");
        products[1].setCategory("ELECTRONICS");

        // Third Product
        products[2] = new Product();
        products[2].setProductId(31094);
        products[2].setProductName("SHOES");
        products[2].setCategory("FOOTWEAR");

        // Fourth Product
        products[3] = new Product();
        products[3].setProductId(30098);
        products[3].setProductName("DRESS");
        products[3].setCategory("CLOTHING");
        
		Product p1=new Product();
		System.out.println("Enter your choice 1.Linear Search\n 2.Binary Search\n");
		int x=sc.nextInt();
		System.out.println("Enter the target value:");
		int target=sc.nextInt();
		if(x==1) {
			Product res=LinearSearch(products, target);
			System.out.println("The element after search is :"+res);
		}else if(x==2) {
			Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
			Product res=BinarySearch(products, target);
			System.out.println("The element after search is :"+res);
			
		}
		
		
		
	}
	//here in linear search we can use unsorted arrays and time complexity is o(n)
	public static Product LinearSearch(Product[] products,int target) {
		for(Product product: products) {
			if(product.getProductId()==target) {
				return product;
			}
		}
		return null;
	}
	
	//here in binary search we use the sorted arrays and tie complexity is o(log n)
	//here we calculate the mid value and then search 
	public static Product BinarySearch(Product[] products,int target) {
		int left=0,right=products.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(products[mid].getProductId()==target) {
				return products[mid];
			}else if(products[mid].getProductId()<target) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return null;
	}
	
}
