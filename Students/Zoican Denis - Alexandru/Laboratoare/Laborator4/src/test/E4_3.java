package test;

import java.awt.Color;

public class E4_3 {
	
	/*
	 Extinderea clasei Autovehicul
	 */
	
	public static void main(String[] args) {
		 Autovehicul2 ex = new Autovehicul2();
		 
		 ex.accelerare();
		 System.out.println("Viteza este "+ex.getViteza());
		 ex.schimbareTreapta(2);
		 System.out.println("Treapta este "+ex.getTreapta());
		 ex.oprire();
		 System.out.println("Viteza este "+ex.getViteza());
		 ex.accelerare(23);
		 System.out.println("Viteza este "+ex.getViteza());
		 System.out.println("Viteza dupa ce acceleram este "+ex.accelerare(2.3));
	 }
}
