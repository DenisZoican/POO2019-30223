package Colocviu;

import java.util.ArrayList;

public class Pacient implements Comparable<Pacient> {
	private Boolean boala;
	private String nume;
	private String prenume;
	private Integer varsta;
	private String sex;
	private ArrayList<Medicament> reteta;

	public Pacient(String nume, String prenume, Integer varsta, String sex) {
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.sex = sex;
		setReteta(new ArrayList<Medicament>());
	}

	public Integer grad_severitate() {
		Integer suma = 0;
		if (boala == true) {
			suma += 100;
		} else {
			suma += 200;
		}

		suma += reteta.size() * 10;

		return suma;

	}

	public Boolean getBoala() {
		return boala;
	}

	public void setBoala(Boolean boala) {
		this.boala = boala;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Integer getVarsta() {
		return varsta;
	}

	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public ArrayList<Medicament> getReteta() {
		return reteta;
	}

	public void setReteta(ArrayList<Medicament> reteta) {
		this.reteta = reteta;
	}

	@Override
	public int compareTo(Pacient o) {
		if (o.getBoala()==this.boala) {
			return 0;
		} else {
			if (o.getBoala() == true) {
				return 1;
			}
			return -1;
		}
	}
}
