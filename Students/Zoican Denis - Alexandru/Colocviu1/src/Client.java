import java.util.ArrayList;

public class Client extends Persoana{

	private int numarProduse;
	private ArrayList<Produs> produse;
	
	public Client(int id, String nume) {
		super(id, nume);
		produse = new ArrayList<Produs>();
	}
	
	
	public void adaugaProdus(Produs p) {
		for(Produs prod:produse) {
			if(prod.getNume()==p.getNume() && prod.getPret()==p.getPret())
			{
				int cantitateNoua = prod.getNrExemplare()+p.getNrExemplare();
				prod.setNrExemplare(cantitateNoua);
				return;
			}
		}
		
		numarProduse++;
		produse.add(p);
	}
	
	public int getNrProduse() {
		return numarProduse;
	}
	
	public ArrayList<Produs> getProduse() {
		return produse;
	}
	
	public void setNrProduse(int a)
	{
		this.numarProduse = a;
	}
	
	public void setProduse(ArrayList<Produs> a)
	{
		this.produse = a;
	}
	
	public String toString() {
		String s = new String("Ma numesc "+super.getNume()+" si am id-ul "+super.getId()+".\nAm cumparat "+this.numarProduse+" produse.\n");
		
		for(Produs c:produse) {
			s = s.concat(c.getNume()+" -- "+c.getNrExemplare()+"\n");
		}
		return s;
	}
	
}
