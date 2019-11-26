import java.util.Arrays;

public class MainPersoana {

	public static void main(String[] args) {

		/// Persoane sortate dupa nume
		Persoana[] persoane = new Persoana[20];

		persoane[0] = new Persoana("Zoican", "Denis", 12, true);
		persoane[1] = new Persoana("Popescu", "Denis", 2, true);
		persoane[2] = new Persoana("Sebastian", "Denis", 3, true);
		persoane[3] = new Persoana("Denis", "Denis", 3, true);
		persoane[4] = new Persoana("Mihut", "Denis", 4, true);
		persoane[5] = new Persoana("Zoican", "Denis", 2, true);

		Arrays.sort(persoane, 0, 6);

		for (Persoana p : persoane) {
			if (p != null)
				System.out.println(p.getNume() + " " + p.getPrenume());
		}

		/// Persoane sortate dupa varsta

		persoane[0].setSortareTip(false);
		persoane[1].setSortareTip(false);
		persoane[2].setSortareTip(false);
		persoane[3].setSortareTip(false);
		persoane[4].setSortareTip(false);
		persoane[5].setSortareTip(false);

		Arrays.sort(persoane, 0, 6);

		System.out.println();
		for (Persoana p : persoane) {
			if (p != null)
				System.out.println(p.getNume() + " " + p.getPrenume()+ " varsta:"+p.getVarsta());
			
		}

	}

}
