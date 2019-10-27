package test;

import java.awt.Color;

public class E4_4 {
	
	public static void main(String[] args) {
		Sofer sofer = new Sofer("Zoican","Marius",23,23);
		Autovehicul3 ex = new Autovehicul3("SAD",Color.green,23,23,23,sofer);
		
		ex.sofer.striga();
		System.out.println(ex.sofer.nume);
		
	 }
}
