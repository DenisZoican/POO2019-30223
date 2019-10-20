import java.text.DecimalFormat;

public class Functions {
	
	static void MULTIPLY (String a,String b)
	{
		String[] a2 = a.split(" ");
		String[] b2 = b.split(" ");
		
		int n1 = a2.length;
		int n2 = b2.length;
		
		int ns = n1-1+n2;
		int s[] = new int[ns];
		
		for(int i=0;i<ns;i++)
		{
			s[i] = 0;
		}
		for(int i=n2-1;i>=0;i--)
		{
			for(int j=n1-1;j>=0;j--)
			{
				s[i+j] += Integer.parseInt(a2[j])*Integer.parseInt(b2[i]);
			}
		}
		
		for(int i=0;i<ns;i++)
		{
			if(s[i]!=0)
			{
				if(s[i]>0 && i!=0)
					System.out.print("+");
				System.out.print(s[i]);
				if(i!=ns-1)
					System.out.print("*x^"+(ns-i-1));
			}
		}
		System.out.println();
	}
	
	static void DIVIDE (String a,String b)
	{
		String[] a2 = a.split(" ");
		String[] b2 = b.split(" ");
		
		int n1 = a2.length;
		int n2 = b2.length;
		
		double[] a3 = new double[n1];
		for(int i=0;i<n1;i++)
			a3[i]=Double.parseDouble(a2[i]);
		double[] b3 = new double[n2];
		for(int i=0;i<n2;i++)
			b3[i]=Double.parseDouble(b2[i]);
		
		double[] c3 = new double[Math.max(n1,n2)];
		
		System.out.println(a+" -- "+b);
		
		double n3;
		double coef,putere;
		
		int ok = 0;
		int pas = -1;
		while(ok == 0)
		{
			coef = a3[0]*1.0/b3[0];
			putere = n1-n2;
			n3 = n2+ putere-1-1;
			ok = 0;
			
			if(coef>0 && pas!=-1)
				System.out.print("+");
			System.out.print((int)coef);
			
			if(putere!=0)
				System.out.print("x^"+(int)putere);
			
			
			
			pas=1;
			
			for(int j=0;j<n2;j++)
			{
				c3[j] = (-1)*b3[j]*coef;
			}
			
			for(int j=0;j<n1;j++)
			{
				//System.out.println(c3[j]+" -- ");
			}
			
			int k = 0;
			int n12 = n1;
			for(int j=0;j<n2;j++)
			{
				a3[j] = a3[j] + c3[j];
				if(a3[k]==0)
				{
					n12--;
					k++;
				}
			}
			
			//System.out.println("n1 este "+n1);
			
			for(int j=k;j<n1;j++)
			{
				a3[j-k] = a3[j];
			}
			
			n1 = n12;
			for(int j=0;j<n1;j++)
			{
				//System.out.println(a3[j]+" -- ");
			}
			
			if(n1 < n2)
			{
				System.out.println();
				System.out.println("n1 este "+n1);
				System.out.println();
				for(int j=0;j<n1;j++)
					{
						if(a3[j]!=0)
						{
							if(j!=0 && a3[j]>0)
							{
								System.out.print("+");
							}
							System.out.print((int)a3[j]);
							if(j!=n1-1)
							{
								System.out.print("x^"+(n1-j-1));
							}
						}
					
					}
				ok = 1;
			}
		}
	}
	
	public void rootAprox (String a,double st,double dr)
	{
		String[] a2 = a.split(" ");
		int n1 = a2.length;
		
		double prev1 = Double.MAX_VALUE;
		double sum1 = 1;
		double p = 1.0;
		double m = 0;
		while(sum1 != 0)
		{
			sum1 = 0;
			p = 1.0;
			m = (st+dr)/2;
			for(int i=n1-1;i>=0;i--)
			{
				sum1+=p*Double.parseDouble(a2[i]);
				p=p*m;
			}
			
			if(sum1 > 0)
			{
				dr = m;
			} else {
				st = m;
			}
			
			System.out.println(m + " -- " + sum1);
			
			if(sum1==0 || prev1 == m)
			{
				DecimalFormat numberFormat = new DecimalFormat("#.00");
				System.out.println("Root is " + numberFormat.format(m));
				return;
			}
			prev1 = m;
		}
	}
	
	public void SUBTRACT(String a, String b)
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
		System.out.println();
	}
	
	public void ADD(String a, String b)
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
		System.out.println();
	}
	
	public void EVAL(String a, String b,int sc)
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
		
		System.out.println(sum1+" --- "+sum2);
		
		
	}
	
	public void MUL_SCA(String a, String b,int sc)
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
}
