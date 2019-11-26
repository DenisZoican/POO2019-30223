
public class PersoanaVarsta implements Comparable<Persoana>{
	private String nume;
	private String prenume;
	private int varsta;
	
	public PersoanaVarsta(String nume,String prenume,int varsta) {
		this.varsta = varsta;
		this.nume = nume;
		this.prenume = prenume;
	}
	
	public PersoanaVarsta() {
		this.varsta = -1;
		this.nume = "Undefined";
		this.prenume = "Undefined";
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

	@Override
	public int compareTo(Persoana o) {
		if(this.varsta>o.getVarsta())
			return 1;
		else if(this.varsta < o.getVarsta())
			return -1;
		return 0;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	
	
}
