package testPack;

import java.util.Arrays;

public class Exercitiu5 {

	static void simulare (int b[])
	{
		
		long t = 0;
		int ok = 1;
		while(ok==1)
		{
		t++;
		System.out.println("Incercari:"+t);
		int apar[] = new int[50];
		Arrays.fill(apar, 0);
		
		for(int i=0;i<6;i++)
		{
			int a = 1+(int) (Math.random()*100%49);
			while(apar[a]!=0)
			{
				a = 1+(int) (Math.random()*100%49);
			}
			apar[a]++;
		}
		
		ok = 0;
		for(int i=0;i<6;i++)
		{
			if(apar[b[i]]==0)
			{
				ok=1;
				break;
			} else {
				apar[b[i]]--;
			}
		}
		}
		
		System.out.println("Incercari:"+t);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int b[] = {1,2,12,25,34,42};
		simulare(b);
	}

}
