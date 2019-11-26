
public class Persoana implements Comparable<Persoana>{
	private String nume;
	private String prenume;
	private int varsta;
	private boolean sortareTip;
	
	public Persoana(String nume,String prenume,int varsta,boolean sortareTip) {
		this.setSortareTip(sortareTip);
		this.varsta = varsta;
		this.nume = nume;
		this.prenume = prenume;
	}
	
	public Persoana() {
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
		if(this.sortareTip==true)
		return this.nume.compareTo(o.getNume());
		else
		{
			if(this.varsta > o.varsta)
				return 1;
			else if(this.varsta < o.varsta)
				return -1;
			return 0;
		}
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public boolean isSortareTip() {
		return sortareTip;
	}

	public void setSortareTip(boolean sortareTip) {
		this.sortareTip = sortareTip;
	}
	
	
}
