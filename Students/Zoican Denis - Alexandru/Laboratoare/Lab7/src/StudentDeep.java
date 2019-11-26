
public class StudentDeep implements Cloneable{
	private MasinaDeep masina;
	private String nume;
	private String prenume;
	
	public StudentDeep(MasinaDeep masina,String nume,String prenume) {
		this.masina = masina;
		this.nume = nume;
		this.prenume = prenume;
	}
	
	protected Object clone() throws CloneNotSupportedException
    {
		StudentDeep s = (StudentDeep) super.clone();
		s.masina = (MasinaDeep) masina.clone();
		return s;
    }
	
	public MasinaDeep getMasina() {
		return masina;
	}
	public void setMasina(MasinaDeep m) {
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
