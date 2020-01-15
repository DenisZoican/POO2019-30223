package Model;

import java.util.Date;

import Colocviu.Angajat;
import Colocviu.Doctor;
import Colocviu.Medicament;
import Colocviu.Pacient;

public class MainModel {
	public Angajat[] a ;
	public MainModel() {

		a = new Angajat[4];
		Angajat a1 = new Angajat("Zoican", "1230", new Date(), 0.0);
		Angajat a2 = new Angajat("Zoican1", "1231", new Date(), 0.0);
		Angajat a3 = new Angajat("Zoican2", "1232", new Date(), 0.0);
		Angajat a4 = new Angajat("Zoican3", "1233", new Date(), 0.0);

		a[0] = a1;
		a[1] = a2;
		a[2] = a3;
		a[3] = a4;
		
		Pacient p1 = new Pacient("Popescu", "Dan", 21, "M");
		Pacient p2 = new Pacient("Popescu1", "Dan1", 21, "M");
		Pacient p3 = new Pacient("Popescu2", "Dan2", 21, "M");
		Pacient p4 = new Pacient("Popescu3", "Dan3", 21, "M");

		Doctor d = new Doctor("Zoican", "123", new Date(), 0.0);

		Medicament m1 = new Medicament("Nurofen", 25.0);
		Medicament m2 = new Medicament("Paduden", 15.0);
		Medicament m3 = new Medicament("Vitamina C", 5.0);
		Medicament m4 = new Medicament("Normix", 125.0);
		Medicament m5 = new Medicament("Pastila", 251.0);
		Medicament m6 = new Medicament("Capsule", 155.0);
		Medicament m7 = new Medicament("Sirop", 52.0);
		Medicament m8 = new Medicament("Vitamina", 225.0);

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

		
		a1.process_reteta(p1);
		a2.process_reteta(p2);
		a3.process_reteta(p3);
		a4.process_reteta(p4);
	}

}
