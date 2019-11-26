package test;

public class Lucrator {
	private String nume;
	private CalendarLucru calendarLucru;
	
	public Lucrator (String nume,CalendarLucru calendarLucru) {
		this.nume = nume;
		this.calendarLucru = calendarLucru;
	}
	
	public void lucreaza(String zi) throws ExceptieZiNelucratoare {
		if(zi.equals("Luni")) {
			if(calendarLucru.getZile()[0].getLucratoare())
			{
				System.out.println("Ziua de luni este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie:Ziua de luni este nelucratoare pentru "+nume);
			}
		} else if(zi.equals("Marti")) {
			if(calendarLucru.getZile()[1].getLucratoare())
			{
				System.out.println("Ziua de marti este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie:Ziua de marti este nelucratoare pentru "+nume);
			}
		} else if(zi.equals("Miercuri")) {
			if(calendarLucru.getZile()[2].getLucratoare())
			{
				System.out.println("Ziua de miercuri este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie:Ziua de miercuri este nelucratoare pentru "+nume);
			}
		} else if(zi.equals("Joi")) {
			if(calendarLucru.getZile()[3].getLucratoare())
			{
				System.out.println("Ziua de joi este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie:Ziua de joi este nelucratoare pentru ");
			}
		} else if(zi.equals("Vineri")) {
			if(calendarLucru.getZile()[4].getLucratoare())
			{
				System.out.println("Ziua de vineri este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie:Ziua de vineri este nelucratoare pentru "+nume);
			}
		} else if(zi.equals("Sambata")) {
			if(calendarLucru.getZile()[5].getLucratoare())
			{
				System.out.println("Ziua de sambata este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie:Ziua de sambata este nelucratoare pentru "+nume);
			}
		} else if(zi.equals("Duminica")) {
			if(calendarLucru.getZile()[6].getLucratoare())
			{
				System.out.println("Ziua de duminica este lucratoare pentru "+nume);
			}
			else {
				throw new ExceptieZiNelucratoare("Exceptie: Ziua de duminica este nelucratoare pentru "+nume);
			}
		} else {
			throw new ExceptieZiNelucratoare("Exceptie:"+zi+" nu este o zi a saptamanii");
		}
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public CalendarLucru getCalendarLucru() {
		return calendarLucru;
	}
	public void setCalendarLucru(CalendarLucru calendarLucru) {
		this.calendarLucru = calendarLucru;
	}
}
