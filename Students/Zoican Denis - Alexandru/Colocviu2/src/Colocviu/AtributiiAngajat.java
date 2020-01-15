package Colocviu;

public interface AtributiiAngajat {
	public void add_med(Medicament s,Farmacie f);
	public void remove_med(Medicament s,Farmacie f);
	public Integer stoc_med(Medicament s,Farmacie f);
	public Boolean find_med(Medicament s,Farmacie f);
	public void change_stoc(Medicament s,Integer v,Farmacie f);
	public void process_reteta(Pacient p);
}
