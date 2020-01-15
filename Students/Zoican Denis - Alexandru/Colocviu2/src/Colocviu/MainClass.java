package Colocviu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) {

	
		Angajat a = new Angajat("Zoican","123",new Date(),0.0);
		
		Pacient p1 = new Pacient("Popescu","Dan",21,"M");
		Pacient p2 = new Pacient("Popescu1","Dan1",21,"M");
		Pacient p3 = new Pacient("Popescu2","Dan2",21,"M");
		Pacient p4 = new Pacient("Popescu3","Dan3",21,"M");
		
		Doctor d = new Doctor("Zoican","123",new Date(),0.0);
		
		Medicament m1 = new Medicament("Nurofen",25.0);
		Medicament m2 = new Medicament("Paduden",15.0);
		Medicament m3 = new Medicament("Vitamina C",5.0);
		Medicament m4 = new Medicament("Normix",125.0);
		Medicament m5 = new Medicament("Pastila",251.0);
		Medicament m6 = new Medicament("Capsule",155.0);
		Medicament m7 = new Medicament("Sirop",52.0);
		Medicament m8 = new Medicament("Vitamina",225.0);
		
		
		d.add_reteta(p1, m1);
		d.add_reteta(p1, m2);
		d.add_reteta(p1, m3);
		
		d.add_reteta(p2, m5);
		d.add_reteta(p2, m2);
		d.add_reteta(p2, m3);
		
		d.add_reteta(p3, m6);
		d.add_reteta(p3, m2);
		d.add_reteta(p3, m1);
		
		d.add_reteta(p4, m1);
		d.add_reteta(p4, m2);
		d.add_reteta(p4, m6);
		
		Pacient[] ar = new Pacient[4];
		ar[0]=p1;
		ar[1]=p2;
		ar[2]=p3;
		ar[3]=p4;
		
		d.consultatie(p1);
		d.consultatie(p2);
		d.consultatie(p3);
		d.consultatie(p4);
		
		Arrays.sort(ar);
		
		for(Pacient p:ar) {
			System.out.println(p.getBoala());
			d.process_reteta(p);
		}
		
		System.out.println(d.getBonus_salariu());
		
		///Test clone
		Farmacie f = new Farmacie("s","s","s","s");
		Farmacie f2 = null;
		try {
			f2 = (Farmacie) f.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		f.setAdresa("Adresa valida");
		
		System.out.println(f.getAdresa()+" "+f2.getAdresa());
		
	}

}
