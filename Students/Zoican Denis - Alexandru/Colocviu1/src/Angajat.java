import java.util.ArrayList;
import java.util.Date;

public class Angajat extends Persoana implements Comparable<Angajat> {

	private Date date;
	private int nrClienti;
	private ArrayList<Client> clienti;

	public Angajat(int id, String nume, Date date) {
		super(id, nume);
		this.date = date;
		this.clienti = new ArrayList<Client>();
	}

	public int getNrClienti() {
		return nrClienti;
	}

	public ArrayList<Client> getClienti() {
		return clienti;
	}

	public void setNrClienti(int a) {
		nrClienti = a;
	}

	public void setClienti(ArrayList<Client> a) {
		clienti = a;
	}

	public double servireClient(Client a) {
		double suma = 0;
		for (Produs c : a.getProduse()) {
			suma += c.getPret()*c.getNrExemplare();
		}

		int clientEx = 0;
		for (Client c : clienti) {
			if (c.getNume() == a.getNume() && c.getId() == a.getId()) {
				clientEx = 1;
				break;
			}
		}

		if (clientEx == 0) {
			clienti.add(a);
			nrClienti++;
		}

		return suma;
	}

	public String toString() {
		String s = new String(
				"Ma numesc " + super.getNume() + " si am id-ul " + super.getId() + ".Am servit clientii:\n");
		for (Client c : clienti) {
			s = s.concat(c.getNume() + "\n");
		}
		s = s.concat("M-am angajat pe data de " + date + " si am servit pana acum " + nrClienti + " clienti\n");
		return s;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Angajat o) {
		if (this.nrClienti > o.getNrClienti())
			return 1;
		else if (this.nrClienti < o.getNrClienti())
			return -1;
		else
			return 0;
	}

}
