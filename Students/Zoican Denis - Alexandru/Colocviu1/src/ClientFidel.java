import java.util.ArrayList;

public class ClientFidel extends Client implements Comparable<ClientFidel> {
	private int nrPuncte;
	private int discount;

	ClientFidel(int id, String nume) {
		super(id, nume);
	}

	public void adaugaProdus(Produs p) {
		double suma = 0;
		int dif = 0;
		for (Produs prod : super.getProduse()) {
			{
				if (prod.getNume() == p.getNume() && prod.getPret() == p.getPret()) {
					int cantitateNoua = prod.getNrExemplare() + p.getNrExemplare();
					prod.setNrExemplare(cantitateNoua);
					dif = 1;
				}
				suma += prod.getPret() * prod.getNrExemplare();
			}
		}
			
		if(dif!=1)
		{
		super.setNrProduse(super.getNrProduse()+1);
		super.adaugaProdus((p));
		suma+=p.getPret()*p.getNrExemplare();
		}
		
		nrPuncte = (int)suma / 10;
		discount = nrPuncte * 2;
	}

	public String toString() {
		String s = new String("Ma numesc " + super.getNume() + " si am id-ul " + super.getId() + ".\nAm cumparat "
				+ super.getNrProduse() + "produse.\n");
		for (Produs c : super.getProduse()) {
			s = s.concat(c.getNume() + " -- " + c.getNrExemplare() + "\n");
		}
		s = s.concat("Am " + nrPuncte + " puncre si un discount de " + discount + "\n");
		return s;
	}

	@Override
	public int compareTo(ClientFidel o) {
		int suma1 = 0;
		int suma2 = 0;

		for (Produs c : this.getProduse()) {
			suma1 += c.getPret() * c.getNrExemplare();
		}

		for (Produs c : o.getProduse()) {
			suma1 += c.getPret() * c.getNrExemplare();
		}
		if (suma1 < suma2)
			return 1;
		else if (suma1 > suma2)
			return -1;
		return 0;
	}

}
