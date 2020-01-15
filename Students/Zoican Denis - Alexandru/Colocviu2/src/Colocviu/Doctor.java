package Colocviu;

import java.util.Date;

public class Doctor<T> extends Angajat{
	
	public Doctor(String nume, String id, Date data_angajarii, Double bonus_salariu) {
		super(nume, id, data_angajarii, bonus_salariu);
	}

	public void consultatie(Pacient p) {
		int r = ((int) (Math.random() * 10)) % 2;
		p.setBoala(r == 0);
	}

	public void add_reteta(T p, Medicament medicament) {
		/// Stiu ca exista doar un singur tip de Pacient, dar am zis sa verific daca tot folosesc Generic
		if (p instanceof Pacient)
			((Pacient) p).getReteta().add(medicament);
	}
}
