package Colocviu;
import java.util.Date;

public class Angajat implements AtributiiAngajat,Comparable<Angajat>,Cloneable{
	private String nume;
	private String id;
	private Date data_angajarii;
	private Double bonus_salariu;
	
	public Angajat(String nume,String id,Date data_angajarii,Double bonus_salariu) {
		this.nume = nume;
		this.id= id;
		this.data_angajarii = data_angajarii;
		this.bonus_salariu = bonus_salariu;
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		} 
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getData_angajarii() {
		return data_angajarii;
	}
	public void setData_angajarii(Date data_angajarii) {
		this.data_angajarii = data_angajarii;
	}
	public Double getBonus_salariu() {
		return bonus_salariu;
	}
	public void setBonus_salariu(Double bonus_salariu) {
		this.bonus_salariu = bonus_salariu;
	}

	@Override
	public void add_med(Medicament s,Farmacie f) {		
		f.getStoc().put(s, 0);
	}

	@Override
	public void remove_med(Medicament s,Farmacie f) {
		f.getStoc().remove(s);
	}

	@Override
	public Integer stoc_med(Medicament s,Farmacie f) {
		return f.getStoc().get(s);
	}

	@Override
	public Boolean find_med(Medicament s,Farmacie f) {
		return f.getStoc().containsKey(s);
	}

	@Override
	public void change_stoc(Medicament s, Integer v,Farmacie f) {
		f.getStoc().put(s, v);
	}

	@Override
	public void process_reteta(Pacient p) {
		Double suma_total = 0.0;
		for(Medicament c:p.getReteta()) {
			suma_total+=c.getPret();
		}
		this.bonus_salariu += suma_total*0.15/100;
	}

	@Override
	public int compareTo(Angajat o) {
		return (int) (o.getBonus_salariu()-this.bonus_salariu);
	}
}
