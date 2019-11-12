package test;

public class TestGhiozdan {

	public static void main(String[] args) {	
		
		Ghiozdan g = new Ghiozdan();
		
		int counter = 10;
		for(int i=0;i<counter;i++)
		{
			int nr_r = ((int)(Math.random()*10))%2;
			
			if(nr_r==0)
			{
			Caiet c = new Caiet();
			g.add(c);
			} else {
			Manual c = new Manual();
			g.add(c);
			}
		}
		
		System.out.println("Numar rechizite:"+g.getNrRechizite()+"\nNumar caiete:"+g.getNrCaiete()+"\nNumar manuale:"+g.getNrManuale());
		
		System.out.println("\nLista de rechizite:");
		g.listItems();
		
		System.out.println("\nLista de caiete:");
		g.listCaiet();
		
		System.out.println("\nLista de manuale:");
		g.listManual();

		
	}

}
