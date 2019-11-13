
public class Persoana {
	private int id;
	private String nume;
	
	public Persoana(int id,String nume) {
		this.id = id;
		this.nume = nume;
	}
	
	public String toString() {
		return "Numele este "+nume+" si am id-ul "+id;
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
