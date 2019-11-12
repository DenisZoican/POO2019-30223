package test;

import java.util.ArrayList;
import java.util.List;

public class Ghiozdan {
	
	private Rechizita[] rec;
	private int nrMaximRechizite;
	private int nrRechizite;
	
	public Ghiozdan(int nr) {
		rec = new Rechizita[nr];
		nrMaximRechizite = nr;
	}
	
	public Ghiozdan() {
		rec = new Rechizita[20];
		nrMaximRechizite = 20;
	}
	
	public void add(Caiet c)
	{
		rec[nrRechizite++] = c;
	}
	
	public void add(Manual m)
	{
		rec[nrRechizite++] = m;
	}
	
	public void listItems() {
		for(int i=0;i<nrRechizite;i++)
			System.out.println(rec[i].getNume() + " poz este "+i);
	}
	
	public void listManual() {
		for(int i=0;i<nrRechizite;i++)
			if(rec[i] instanceof Manual)
			System.out.println(rec[i].getNume() + " poz este "+i);
	}
	
	public void listCaiet() {
		for(int i=0;i<nrRechizite;i++)
			if(rec[i] instanceof Caiet)
			System.out.println(rec[i].getNume() + " poz este "+i);
	}
	
	public int getNrRechizite() {
		return nrRechizite;
	}
	
	public int getNrManuale() {
		int ok = 0;
		for(int i=0;i<nrRechizite;i++)
			if(rec[i] instanceof Manual)
			ok++;
		return ok;
	}
	
	public int getNrCaiete() {
		int ok = 0;
		for(int i=0;i<nrRechizite;i++)
			if(rec[i] instanceof Caiet)
			ok++;
		return ok;
	}
	
	
}
