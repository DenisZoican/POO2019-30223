package testPack;

public class Exercitiu2 {

	public double f(int a,int b,int c,double x)
	{
		return a*x*x+b*x+c;
	}
	
	public double fd(int a,int b,int c,double x)
	{
		return 2*a*x+b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercitiu2 eu = new Exercitiu2();
		
		int a = 1;
		int b = -4;
		int c = 4;
		double x0 = -20;
		double x1 = x0 - eu.f(a,b,c,x0)/eu.fd(a,b,c,x0);
		
		while(x1-x0 > 0.01)
		{
			x0 = x1;
			x1 =  x0 - eu.f(a,b,c,x0)/eu.fd(a,b,c,x0);
		}
		
		System.out.println(x1);
		
	}

}
