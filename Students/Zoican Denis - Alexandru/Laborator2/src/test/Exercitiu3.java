package test;

import java.util.Scanner;

public class Exercitiu3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		byte a = Byte.MAX_VALUE;
		a += 1;
		short b = Short.MAX_VALUE;
		b += 1;
		int c = Integer.MAX_VALUE;
		c += 1;
		long d = Long.MAX_VALUE;
		d += 1;
		
		System.out.println("Adunam cantitate intrega la MAX_VALUE:\nbyte:"+a+"\nshort:"+b+"\nint:"+c+"\nlong:"+d);
		
		a-=2;
		b-=2;
		c-=2;
		d-=2;
		
		System.out.println("Scadem cantitate intrega la MAX_VALUE:\nbyte:"+a+"\nshort:"+b+"\nint:"+c+"\nlong:"+d);
		
		double e = 1.0/3;
		
		System.out.printf("Numarul zecimal este %.20f \n",e);
		
		
		
	}
}
