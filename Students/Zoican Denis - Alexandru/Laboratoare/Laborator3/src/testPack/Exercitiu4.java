package testPack;

public class Exercitiu4 {

	public double sanse ()
	{
		int n = 49;
		int k = 6;
		
		double p = 1.0;
		for(int i=k;i>=1;i--)
		{
			p=p*(n)/i;
			n--;
		}
		
		return 1.0/p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercitiu4 eu = new Exercitiu4();
		System.out.println(eu.sanse());
	}

}
