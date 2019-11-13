
public class Produs {
	private String nume;
	private double pret;
	private int nrExemplare;
	
	public Produs(String nume,double pret,int nrExemplare){
		this.nume = nume;
		this.pret = pret;
		this.nrExemplare = nrExemplare;
	}

	public boolean verificareStoc() {
		if(nrExemplare>0)
			return true;
		return false;
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public int getNrExemplare() {
		return nrExemplare;
	}

	public void setNrExemplare(int nrExemplare) {
		this.nrExemplare = nrExemplare;
	}
}
