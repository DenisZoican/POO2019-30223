package Colocviu;
import java.util.HashMap;
import java.util.HashSet;

public class Farmacie implements Cloneable {

	private String denumire;
	private String adresa;
	private String numar_de_teledon;
	private String website;
	
	private HashMap<Medicament,Integer> stoc;
	private HashSet<PairAngajat> angajati;
	
	public Farmacie(String denumire,String adresa,String numar_de_telefon,String website) {
		this.denumire = denumire;
		this.adresa = adresa;
		this.numar_de_teledon = numar_de_telefon;
		this.website = website;
		
		stoc = new HashMap<Medicament,Integer>();
		angajati = new HashSet<PairAngajat>();
	}
	
	public Object clone() throws CloneNotSupportedException {
		Farmacie f = (Farmacie) super.clone();
		f.stoc = (HashMap<Medicament,Integer>)stoc.clone();
		f.angajati = (HashSet<PairAngajat>)angajati.clone();
		return f;
	}
	
	public String getDenumire() {
		return denumire;
	}


	
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNumar_de_teledon() {
		return numar_de_teledon;
	}

	public void setNumar_de_teledon(String numar_de_teledon) {
		this.numar_de_teledon = numar_de_teledon;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public HashMap<Medicament,Integer> getStoc() {
		return stoc;
	}

	public void setStoc(HashMap<Medicament,Integer> stoc) {
		this.stoc = stoc;
	}

	public HashSet<PairAngajat> getAngajati() {
		return angajati;
	}

	public void setAngajati(HashSet<PairAngajat> angajati) {
		this.angajati = angajati;
	}
}
