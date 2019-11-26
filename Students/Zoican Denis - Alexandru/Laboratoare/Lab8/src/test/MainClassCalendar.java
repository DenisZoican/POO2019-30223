package test;

public class MainClassCalendar {
	public static void main(String[] args) {
		CalendarLucru cl = new CalendarLucru();
		Lucrator l1 = new Lucrator("Zoican",cl);
		
		try {
			l1.lucreaza("Marti");
		} catch (ExceptieZiNelucratoare e) {
			System.out.println(e.getMessage());
		}
		
		try {
			l1.lucreaza("Sambata");
		} catch (ExceptieZiNelucratoare e) {
			System.out.println(e.getMessage());
		}
		
		try {
			l1.lucreaza("Marti2");
		} catch (ExceptieZiNelucratoare e) {
			System.out.println(e.getMessage());
		}
	}
}
