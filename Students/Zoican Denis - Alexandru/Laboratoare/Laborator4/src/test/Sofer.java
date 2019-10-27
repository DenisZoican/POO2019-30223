package test;

public class Sofer extends Persoana{
	String nume;
	String prenume;
	int varsta;
	int numar_permis;
	
	int toleranta = Integer.MIN_VALUE;
	
	public void striga() {
		System.out.println("Cine ti-a dat permis!?!");
	}
	
	Sofer(String nume,String prenume,int varsta,int numar_permis){
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.numar_permis = numar_permis;
	}
}
