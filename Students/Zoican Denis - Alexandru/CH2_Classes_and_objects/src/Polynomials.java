import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;


public class Polynomials {
	
	static void SUBSTRACT(String a, String b)
	{
		String[] a2 = a.split(" ");
		String[] b2 = b.split(" ");
		
		int n1 = a2.length-1;
		int n2 = b2.length-1;
		
		int nc = Math.max(a2.length, b2.length);
		int sum[] = new int[nc];
		
		for(int i=nc-1;i>=0;i--)
		{
			if(n2<0)
				sum[i] = Integer.parseInt(a2[n1]);
			else if(n1<0)
				sum[i] = Integer.parseInt(b2[n2]);
			else
				sum[i] = Integer.parseInt(a2[n1])-Integer.parseInt(b2[n2]);
			n1--;
			n2--;
		}
		
		for(int i=0;i<nc;i++)
		{
			if(sum[i]!=0)
			{
				if(sum[i]>0 && i!=0)
					System.out.print("+");
				System.out.print(sum[i]);
				if(i!=nc-1)
					System.out.print("*x^"+(nc-i-1));
			}
		}
	}
	
	static void ADD(String a, String b)
	{
		String[] a2 = a.split(" ");
		String[] b2 = b.split(" ");
		
		int n1 = a2.length-1;
		int n2 = b2.length-1;
		
		int nc = Math.max(a2.length, b2.length);
		int sum[] = new int[nc];
		
		for(int i=nc-1;i>=0;i--)
		{
			if(n2<0)
				sum[i] = Integer.parseInt(a2[n1]);
			else if(n1<0)
				sum[i] = Integer.parseInt(b2[n2]);
			else
				sum[i] = Integer.parseInt(a2[n1])+Integer.parseInt(b2[n2]);
			n1--;
			n2--;
		}
		
		for(int i=0;i<nc;i++)
		{
			if(sum[i]!=0)
			{
				if(sum[i]>0 && i!=0)
					System.out.print("+");
				System.out.print(sum[i]);
				if(i!=nc-1)
					System.out.print("*x^"+(nc-i-1));
			}
		}
	}
	
	static void EVAL(String a, String b,int sc)
	{
		String[] a2 = a.split(" ");
		String[] b2 = b.split(" ");
		
		int n1 = a2.length;
		int n2 = b2.length;
		
		int a3[] = new int[n1];
		int b3[] = new int[n2];
		
		int sum1 = 0;
		int sum2 = 0;
		
		int p = 1;
		for(int i=n1-1;i>=0;i--)
		{
			sum1+=p*Integer.parseInt(a2[i]);
			p=p*sc;
		}
		
		p = 1;
		for(int i=n2-1;i>=0;i--)
		{
			sum2+=p*Integer.parseInt(b2[i]);
			p=p*sc;
		}
		
		
	}
	
	static void MUL_SCA(String a, String b,int sc)
	{
		String[] a2 = a.split(" ");
		String[] b2 = b.split(" ");
		
		int n1 = a2.length;
		int n2 = b2.length;
		
		int a3[] = new int[n1];
		int b3[] = new int[n2];
		
		for(int i=0;i<n1;i++)
		{
			a3[i] = Integer.parseInt(a2[i])*sc;
		}
		
		for(int i=0;i<n2;i++)
		{
			b3[i] = Integer.parseInt(b2[i])*sc;
		}
		
		System.out.println("Primul polinom este: ");
		for(int i=0;i<n1;i++)
		{
			if(a3[i]!=0)
			{
				if(a3[i]>0 && i!=0)
					System.out.print("+");
				System.out.print(a3[i]);
				if(i!=n1-1)
					System.out.print("*x^"+(n1-i-1));
			}
		}
		System.out.println();
		
		System.out.println("Al doilea polinom este: ");
		for(int i=0;i<n2;i++)
		{
			if(b3[i]!=0)
			{
				if(b3[i]>0 && i!=0)
					System.out.print("+");
				System.out.print(b3[i]);
				if(i!=n2-1)
					System.out.print("*x^"+(n2-i-1));
			}
		}
		System.out.println();
	}
	
	
	
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\zoica\\eclipse-workspace\\CH2_Classes_and_objects\\src\\pol.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		
		
		
		System.out.println(s1+"--"+s2);
		while(scanner.hasNext())
		{
			String c = scanner.nextLine();
		}
		
		MUL_SCA(s1,s2,3);
	}
}
