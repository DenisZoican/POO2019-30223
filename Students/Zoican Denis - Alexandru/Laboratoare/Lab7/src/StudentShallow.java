
public class StudentShallow implements Cloneable{
	private MasinaShallow masina;
	private String nume;
	private String prenume;
	
	public StudentShallow(MasinaShallow masina,String nume,String prenume) {
		this.masina = masina;
		this.nume = nume;
		this.prenume = prenume;
	}
	
	protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
	
	public MasinaShallow getMasina() {
		return masina;
	}
	public void setMasina(MasinaShallow m) {
		this.masina = m;
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
	
	
}
