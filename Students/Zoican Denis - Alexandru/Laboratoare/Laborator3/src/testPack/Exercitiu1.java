package testPack;

import java.util.Arrays;
import java.util.Scanner;

public class Exercitiu1 {

	public boolean marked[];
	
	public void sieveOfSundaram(int n)
	{
		boolean marked2[] = new boolean[n+23];
		this.marked = new boolean[n+23];
		
		int nNew = (n-2)/2; 
		 
		Arrays.fill(marked2, false);
		Arrays.fill(marked, false);
		
		for (int i=1; i<=nNew; i++) 
		       for (int j=i; (i + j + 2*i*j) <= n; j++) 
		           marked2[i + j + 2*i*j] = true; 
		
		if(n>=2)
		{
			marked[2] = true; 
		}
		
		 for (int i=1; i<=nNew; i++) 
		        if (marked2[i] == false) 
		            {
		        		marked[2*i+1] = true;
		            }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercitiu1 eu = new Exercitiu1();
		eu.sieveOfSundaram(50);
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		if(a%2==1)
			a++;
		
		for(int i=a;i<=b;i=i+2)
		{
			for(int j=1;j<=i/2;j++)
			{
				if(eu.marked[j]==true && eu.marked[i-j]==true)
				{
					System.out.println(i+" DA");
					break;
				}
			}
		}
		
	}
}
