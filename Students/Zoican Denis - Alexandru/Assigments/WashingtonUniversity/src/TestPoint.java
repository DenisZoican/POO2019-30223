import java.util.ArrayList;

public class TestPoint {

	static void firstExample() {
		Point[] a = new Point[10];
		Object[] b;
		b = a;
		b[0] = new Point(10, 20);
	}

	static void secondExample() {
		Point[] a = new Point[10];
		Object[] b;
		b = a;
		b[0] = "hi there";
	}

	static void thirdExample() {

		Point[] a = new Point[10];
		Object[] b;
		b = a;
		//a[0] = "hi there";
	}

	static void fourthExample() {
		ArrayList<Point> a = new ArrayList<Point>();
		ArrayList<Object> b;
		//b = a;
		//b.add(new Point(10, 20));
	}

	public static void main(String[] args) {
		firstExample();
		/// Se executa fara probleme
		try {
			secondExample();
		} catch (ArrayStoreException e) {
			System.out.println("Avem exceptia ArrayStoreException la exemplul 2");
			/// Avem aceasta exceptie deoarece noi asignam lui b Array-ul de la a, dar
			/// acesta este pentru Point, nu pentru
			/// string-uri
		}
		thirdExample();
		/// La al treilea exemplu, avem eroare pentru ca nu putem atribui unui array de
		/// Point un string.La exemplul anterior
		/// a fost posibil acest lucru deoarece ii atribuiam lui b un string, b fiind un
		/// array de Objects, deci de string-uri
		
		fourthExample();
		/// Nu este posibila atribuirea b = a. a este un ArrayList de Point, iar b este un ArrayList de Object. In ciuda
		/// faptului ca Point este o clasa ce mosteneste clasa Object, ArrayList<Point> difere de ArrayList<Object>
	}

}
