import java.math.BigDecimal;

public class MatrixOperations {

	static BigDecimal[][] add(BigDecimal[][] a,BigDecimal[][] b) {
		
		int n1,m1,n2,m2;
		n1 = a.length;
		n2 = b.length;
		
		m1 = a[0].length;
		m2 = b[0].length;
		
		if(n1!=n2 || m1!=m2)
		{
			System.out.println("Nu se poate realiza adunarea");
			return null;
		}
		
		BigDecimal[][] s = new BigDecimal[a.length][a[0].length];
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
			{
				s[i][j]=a[i][j].add(b[i][j]);
			}
		
		return s;
	}
	
	static BigDecimal[][] substract(BigDecimal[][] a,BigDecimal[][] b) {
		
		int n1,m1,n2,m2;
		n1 = a.length;
		n2 = b.length;
		
		m1 = a[0].length;
		m2 = b[0].length;
		
		if(n1!=n2 || m1!=m2)
		{
			System.out.println("Nu se poate realiza scaderea");
			return null;
		}
		
		BigDecimal[][] s = new BigDecimal[a.length][a[0].length];
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
			{
				s[i][j]=a[i][j].subtract(b[i][j]);
			}
		
		return s;
	}
	
	static BigDecimal[][] multiply(BigDecimal[][] a,BigDecimal[][] b) {
		
		int n1,m1,n2,m2;
		n1 = a.length;
		n2 = b.length;
		
		m1 = a[0].length;
		m2 = b[0].length;
		
		if(n1!=n2 || m1!=m2)
		{
			System.out.println("Nu se poate realiza inmultirea");
			return null;
		}
		
		BigDecimal[][] s = new BigDecimal[a.length][a[0].length];
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
			{
				s[i][j] = BigDecimal.valueOf(0);
				for(int z=0;z<m1;z++)
				{
					System.out.println(a[i][z]+"--"+b[z][j]);
					s[i][j]=s[i][j].add(a[i][z].multiply(b[z][j]));
				}
			}
		
		return s;
	}
	
	static BigDecimal determinant(BigDecimal[][] a,int ok) {
		int n = a[0].length;
		
		if(n==1)
			{
			//System.out.println("Test 0 "+a[0][0]);
			return a[0][0];
			}
		
		int sign = 1;
		BigDecimal D = BigDecimal.valueOf(0);
		
		for(int i=0;i<n;i++)
		{
			//System.out.println("val este "+a[0][i]+".n este "+n);
			BigDecimal val = a[0][i];
			BigDecimal[][] s = new BigDecimal[n-1][n-1];
			
			int poz;
			for(int i1=1;i1<n;i1++)
				{
					
					poz = 0;
					for(int j1=0;j1<n;j1++)
						{
							if(j1!=i)
							{
								//System.out.println("Test "+(i1-1)+"--"+poz+"--"+a[i1][j1]);
								s[i1-1][poz] = a[i1][j1];
								poz++;
							}
						}
				}
			D = D.add(val.multiply(BigDecimal.valueOf(sign)).multiply(determinant(s,ok+1)));
			sign *= -1;
		}
		return D;
	}

	static BigDecimal[][] multiplyScalar(BigDecimal[][] a,BigDecimal b) {
		
		int n1,m1;
		n1 = a.length;
		m1 = a[0].length;
		
		BigDecimal[][] s = new BigDecimal[a.length][a[0].length];
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
			{
				s[i][j] = a[i][j].multiply(b);
			}
		
		return s;
	}
	
	static boolean isZeroMatrix (BigDecimal[][] a)
	{
		int n1 = a.length;
		int m1 = a[0].length;
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
			{
				if(a[i][j].compareTo(new BigDecimal(0))!=0)
					return false;
			}
		return true;
	}
	static boolean areEqual(BigDecimal[][] a,BigDecimal[][] b)
	{
		int n1 = a.length;
		int m1 = a[0].length;
		
		int n2 = b.length;
		int m2 = b[0].length;
		
		if(n1!=n2 || m1!=m2)
			{
			System.out.println("23");
			return false;
			}
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
				{
				System.out.println("-> "+a[i][j]+"--"+b[i][j]);
					if(a[i][j].compareTo(b[i][j])!=0)
					{
						return false;
					}
				}
		return true;
	}
	
	static boolean isIdentityMatrix(BigDecimal[][] a)
	{
		int n1 = a.length;
		int m1 = a[0].length;
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
			{
				if(i==j && a[i][j].compareTo(new BigDecimal(1))!=0)
				{
					return false;
				}
			}
		return true;
	}
	
	static BigDecimal fillDegree(BigDecimal[][] a) {
		int n1 = a.length;
		int m1 = a[0].length;
		
		BigDecimal p = new BigDecimal(0);
		BigDecimal total = new BigDecimal(n1).multiply(new BigDecimal(m1));
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
				if(a[i][j].compareTo(new BigDecimal(0))!=0)
				{
					p = p.add(new BigDecimal(1));
				}
		
		if(p.compareTo(new BigDecimal(0))==0)
			return new BigDecimal(0);
		
		return p.divide(total,4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100));
	}
	
	public static void main(String[] args) {
	
		BigDecimal[][] a1 = {{new BigDecimal(1),new BigDecimal(1),new BigDecimal(0)},
							 {new BigDecimal(1),new BigDecimal(1),new BigDecimal(0)},
							 {new BigDecimal(1),new BigDecimal(1),new BigDecimal(0)}};
		
		BigDecimal[][] a2 = {{new BigDecimal(1),new BigDecimal(3),new BigDecimal(5)},
				 {new BigDecimal(4),new BigDecimal(2),new BigDecimal(2)},
				 {new BigDecimal(1),new BigDecimal(6),new BigDecimal(6)}};
		
		BigDecimal[][] m = multiplyScalar(a1,BigDecimal.valueOf(2));
		
		for(int i=0;i<3;i++)
			{
			for(int j=0;j<3;j++)
				System.out.print(m[i][j]+" ");
			System.out.println();
			}

		
		System.out.println("Det este "+fillDegree(a1));
	
		
	}
}
