import java.awt.Color;

public class MainStudent {
	public static void main(String[] args) throws CloneNotSupportedException {

		/// Shallow example
		System.out.println(" ----- Shallow example ----- \n ");
		MasinaShallow masinaShallow = new MasinaShallow("BMW", Color.BLACK);
		StudentShallow studentShallow = new StudentShallow(masinaShallow, "Zoican", "Denis");

		StudentShallow studentShallowCopy = (StudentShallow) studentShallow.clone();

		studentShallow.getMasina().schimbaCuloare(Color.red);

		System.out.println("Student original : \n" + "Nume:" + studentShallow.getNume() + "\nPrenume:"
				+ studentShallow.getPrenume() + "\nMasinca marca:" + studentShallow.getMasina().getMarca()
				+ "\nMasina culoare:" + studentShallow.getMasina().getColor());
		System.out.println("\n\nStudent copy : \n" + "Nume:" + studentShallowCopy.getNume() + "\nPrenume:"
				+ studentShallowCopy.getPrenume() + "\nMasinca marca:" + studentShallowCopy.getMasina().getMarca()
				+ "\nMasina culoare:" + studentShallowCopy.getMasina().getColor());
		/// Se schimba culoarea in ambele obiecte

		// Deep example
		System.out.println("\n\n ----- Deep example ----- \n ");
		MasinaDeep masinaDeep = new MasinaDeep("BMW", Color.green);
		StudentDeep studentDeep = new StudentDeep(masinaDeep, "Zoican", "Denis");

		StudentDeep studentDeepCopy = (StudentDeep) studentDeep.clone();

		studentDeep.getMasina().schimbaCuloare(Color.red);

		System.out.println("Student original : \n" + "Nume:" + studentDeep.getNume() + "\nPrenume:"
				+ studentDeep.getPrenume() + "\nMasinca marca:" + studentDeep.getMasina().getMarca()
				+ "\nMasina culoare:" + studentDeep.getMasina().getColor());
		System.out.println("\n\nStudent copy : \n" + "Nume:" + studentDeepCopy.getNume() + "\nPrenume:"
				+ studentDeepCopy.getPrenume() + "\nMasinca marca:" + studentDeepCopy.getMasina().getMarca()
				+ "\nMasina culoare:" + studentDeepCopy.getMasina().getColor());

		/// Nu se schimba valoarea in ambele obiecte

	}

}
