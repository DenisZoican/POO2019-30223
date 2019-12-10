package test;

import java.util.ArrayList;

public class FacebookAccount {
	private String nume;
	private String adresa;
	private int varsta;
	private ArrayList<FacebookAccount> prieteni;

	public FacebookAccount(String nume, String adresa, int varsta) {
		this.setNume(nume);
		this.prieteni = new ArrayList<FacebookAccount>();
		this.setAdresa(adresa);
		this.setVarsta(varsta);
	}

	public void arataPrieteni() {
		int k = 1;
		System.out.println("Lista de prieteni "+nume+"\n");
		for (FacebookAccount c : prieteni) {
			System.out.println("Prieten " + k + "\nNume: " + c.getNume() + "\nAdresa: " + c.getAdresa() + "\nVarsta: "
					+ c.getVarsta() + "\n\n");
			k++;
		}
	}

	public void arataPrieteniLocatie(String locatie) {
		int k = 1;
		System.out.println("Lista de prieteni din locatie "+nume+"\n");
		for (FacebookAccount c : prieteni) {
			if (c.getAdresa().compareTo(locatie) == 0) {
				System.out.println("Prieten " + k + "\nNume: " + c.getNume() + "\nAdresa: " + c.getAdresa()
						+ "\nVarsta: " + c.getVarsta() + "\n\n");
				k++;
			}
		}
	}

	public void adaugaPrieten(FacebookAccount p) {
		prieteni.add(p);
	}

	public void stergePrieten(FacebookAccount p) {
		prieteni.remove(p);
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public ArrayList<FacebookAccount> getPrieteni() {
		return prieteni;
	}

	public void setPrieteni(ArrayList<FacebookAccount> prieteni) {
		this.prieteni = prieteni;
	}
}
