import java.util.ArrayList;
import java.util.Arrays;

public class Supermarket {
	private ArrayList<Angajat> angajati;
	private ArrayList<ClientFidel> clientiFideli;
	private ArrayList<Produs> produse;
	private ArrayList<Client> clienti;
	
	public Supermarket() {
		this.angajati=new ArrayList<Angajat>();
		this.clientiFideli= new ArrayList<ClientFidel>();
		this.produse =new ArrayList<Produs>();
		this.clienti = new ArrayList<Client>();
	}
	
	public void arataStatistici() {
		int clientiFideliNr = 0;
		int clientiNr = 0;
		
		for(Client c:clienti) {
			ArrayList<Produs> prod = c.getProduse();
			
			for(Produs p:prod) {
				clientiNr+=p.getNrExemplare();
			}
		}
		
		for(ClientFidel c:clientiFideli) {
			ArrayList<Produs> prod = c.getProduse();
			
			for(Produs p:prod) {
				clientiFideliNr+=p.getNrExemplare();
			}
		}
		
		System.out.println("Clintii au cumparat "+clientiNr+"\nClientii fideli au cumparat "+clientiFideliNr+"\n");
		
	}
	
	public int adaugaProdus(Produs p) {
		int dif = 0;
		for(Produs c:produse) {
			if(c.getNume()==p.getNume())
				dif=1;
		}
		
		if(dif==0)
		produse.add(p);
		
		return dif;
	}
	
	public int adaugaClientFidel(ClientFidel p) {
		int dif = 0;
		for(ClientFidel c:clientiFideli) {
			if(c.getNume()==p.getNume() && c.getId()==p.getId())
				dif=1;
		}
		if(dif==0)
		clientiFideli.add(p);
		
		return dif;
	}
	
	public int adaugaClient(Client p) {
		int dif = 0;
		for(Client c:clienti) {
			if(c.getNume()==p.getNume() && c.getId()==p.getId())
				dif=1;
		}
		if(dif==0)
		clienti.add(p);
		
		return dif;
	}
	
	public int adaugaAngajat(Angajat p) {
		int dif = 0;
		for(Angajat c:angajati) {
			if(c.getNume()==p.getNume() && c.getId()==p.getId())
				dif=1;
		}
		if(dif==0)
		angajati.add(p);
		
		return dif;
	}
	
	public void arataAngajati() {
		int i = 0;
		Angajat[] an = new Angajat[angajati.size()];
		for(Angajat c:angajati) {
			an[i] = c;
			i++;
		}
		Arrays.sort(an,0,i);
		
		System.out.println("Avem "+i+" angajati.\n");
		for(int j =0;j<i;j++)
		{
			System.out.println(an[j]);
		}
		System.out.println();
	}
	
	public void arataClientiFideli() {
		int i = 0;
		ClientFidel[] an = new ClientFidel[clientiFideli.size()];
		for(ClientFidel c:clientiFideli) {
			an[i] = c;
			i++;
		}
		Arrays.sort(an,0,i);
		
		for(int j =0;j<i;j++)
		{
			System.out.println(an[j]);
		}
		System.out.println();
	}

	public ArrayList<Angajat> getAngajati() {
		return angajati;
	}
	
	public void setAngajati(ArrayList<Angajat> angajati) {
		this.angajati = angajati;
	}
	
	public ArrayList<ClientFidel> getClientiFideli() {
		return clientiFideli;
	}
	
	public void setClientiFideli(ArrayList<ClientFidel> clientiFideli) {
		this.clientiFideli = clientiFideli;
	}

	public ArrayList<Produs> getProduse() {
		return produse;
	}

	public void setProduse(ArrayList<Produs> produse) {
		this.produse = produse;
	}
	
}
