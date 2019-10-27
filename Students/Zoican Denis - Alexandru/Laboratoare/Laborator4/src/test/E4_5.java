package test;

import java.awt.Color;

public class E4_5 {
	/*
	 Adaugarea a 2 clase pentru extinderea claselor Autovehicul4 si Sofer
	 */
	public static void main(String[] args) {
		Sofer sofer = new Sofer("Zoican","Marius",23,23);
		Autovehicul4 ex = new Autovehicul4("SAD",Color.green,23,23,23,sofer);
		
		System.out.println(ex.an_inventat);
		System.out.println(ex.sofer.an_nastere);
		
	 }
}
