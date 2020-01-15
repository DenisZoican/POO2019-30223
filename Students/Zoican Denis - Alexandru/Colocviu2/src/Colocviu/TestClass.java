package Colocviu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map.Entry;

import org.junit.Test;

public class TestClass {
	
	@Test
	public void test() {
		
		///Cand face o reteta,sa adaugam la angajat
		Angajat a = new Angajat("Zoican","123",new Date(),0.0);
		Pacient p = new Pacient("Popescu","Dan",21,"M");
		Doctor d = new Doctor("Zoican","123",new Date(),0.0);
		
		Medicament m1 = new Medicament("Nurofen",25.0);
		Medicament m2 = new Medicament("Paduden",15.0);
		Medicament m3 = new Medicament("Vitamina C",5.0);
		Medicament m4 = new Medicament("Normix",125.0);
		
		Farmacie f = new Farmacie("FarmaciaVesela","Pe colt","0766446399","www.veselieLaPastila.com");
		
		f.getStoc().put(m1, 1);
		f.getStoc().put(m2, 10);
		f.getStoc().put(m3, 12);
		
		for(Entry<Medicament, Integer> m:f.getStoc().entrySet()) {
			System.out.println(m.getKey().getNume()+" -- "+m.getValue());
		}
		
		///Adaugare medicament
		a.add_med(m4, f);
		assertTrue(f.getStoc().containsKey(m4));
		
		
		///Eliminare medicament
		a.remove_med(m4, f);
		assertFalse(f.getStoc().containsKey(m4));
		
		
		///Verificare stoc
		assertTrue(a.stoc_med(m2, f)==10);
		
		
		///Verificare daca medicament exista
		assertTrue(a.find_med(m2, f)==true);
		assertTrue(a.find_med(m4, f)==false);
		
		
		///Schimbare stoc
		a.change_stoc(m2, 100, f);
		assertTrue(f.getStoc().get(m2)==100);
		
		///Procesare
		d.add_reteta(p, m1);
		d.add_reteta(p, m2);
		d.add_reteta(p, m4);
		
		a.process_reteta(p);
		assertTrue(a.getBonus_salariu()==0.2475);
		
		
	}
}
