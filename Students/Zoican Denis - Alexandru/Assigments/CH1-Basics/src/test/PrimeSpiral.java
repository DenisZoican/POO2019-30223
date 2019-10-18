package test;

public class PrimeSpiral {

	static boolean prim(int n) ///Poate fi folosit Sive of Eratosthenes pentru a imbunatati performanta)
	{
		for(int i=2;i*i<=n;i++)
			if(n%i==0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3;
		int total = 1;
		double ratio = 100.0;
		int prim_nr = 0;
		
		while(ratio > 10 )
		{
			total+=4;
			int p = i*i;
			if(prim(p)==true)
				prim_nr++;
			
			p -= (i-1);
			if(prim(p)==true)
				prim_nr++;
			
			p -= (i-1);
			if(prim(p)==true)
				prim_nr++;
			
			p -= (i-1);
			if(prim(p)==true)
				prim_nr++;
			
			ratio = (prim_nr*1.0)/total*100;
			i=i+2;
		}
		
		System.out.println("Latura este "+(i-2));		
	}

}
