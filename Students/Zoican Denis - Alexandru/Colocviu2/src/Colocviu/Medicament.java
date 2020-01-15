package Colocviu;

public class Medicament implements Cloneable {
	private String nume;
	private Double pret;

	public Medicament(String nume, Double pret) {
		this.nume = nume;
		this.pret = pret;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String toString() {
		return nume;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Double getPret() {
		return pret;
	}

	public void setPret(Double pret) {
		this.pret = pret;
	}

}
