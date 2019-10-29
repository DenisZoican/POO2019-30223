package test;

import java.awt.Color;

public class E4_2 {
	/*
	 Exemplificare folosire clasa Autovehicul
	 */
	public static void main(String[] args) {
		 Autovehicul ex = new Autovehicul();
		 
		 ex.accelerare(20);
		 ex.decelerare(10);
		 System.out.println("Viteza este "+ex.getViteza());
		 ex.schimbareTreapta(2);
		 System.out.println("Treapta este "+ex.getTreapta());
		 ex.oprire();
		 System.out.println("Viteza este "+ex.getViteza());
		 ex.setCuloare(Color.green);
		 System.out.println("Culoarea este "+ex.getCuloare());
	 }
}
