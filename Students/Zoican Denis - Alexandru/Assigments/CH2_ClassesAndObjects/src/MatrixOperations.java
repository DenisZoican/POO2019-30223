import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

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
		
		if(m1!=n2)
		{
			System.out.println("Nu se poate realiza inmultirea");
			return null;
		}
		
		BigDecimal[][] s = new BigDecimal[n1][m2];
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m2;j++)
			{
				s[i][j] = BigDecimal.valueOf(0);
				for(int z=0;z<m1;z++)
				{
					s[i][j]=s[i][j].add(a[i][z].multiply(b[z][j]));
				}
			}
		
		return s;
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
	
	
	static BigDecimal determinant(BigDecimal[][] a) {
		int n = a[0].length;
		
		if(n==1)
			{
			return a[0][0];
			}
		
		int sign = 1;
		BigDecimal D = BigDecimal.valueOf(0);
		
		for(int i=0;i<n;i++)
		{
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
								
								s[i1-1][poz] = a[i1][j1];
								poz++;
							}
						}
				}
			D = D.add(val.multiply(BigDecimal.valueOf(sign)).multiply(determinant(s)));
			sign *= -1;
		}
		return D;
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
			return false;
			}
		
		for(int i=0;i<n1;i++)
			for(int j=0;j<m1;j++)
				{
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
		BigDecimal a[][]= {
				{new BigDecimal(2),new BigDecimal(-2),new BigDecimal(1)},
				{new BigDecimal(1),new BigDecimal(3),new BigDecimal(-2)},
				{new BigDecimal(1),new BigDecimal(-1),new BigDecimal(-1)}
				};
		BigDecimal b[][]= {
				{new BigDecimal(-3)},
				{new BigDecimal(13)},
				{new BigDecimal(2)},
				};
		
		///Adjugate matrix
		BigDecimal adj[][] = new BigDecimal[a.length][a[0].length];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
			{
				BigDecimal d[][] = new BigDecimal[a.length-1][a[0].length-1];
				int v=0;
				for(int z=0;z<a.length;z++)
					{
					int c = 0;
					for(int x=0;x<a[0].length;x++)
					{
						if(z!=i && j!=x)
						{
							d[v][c] = a[z][x]; 
							c++;
							if(c==a[0].length-1)
								v++;
						}
					}
					}				
				adj[j][i] = determinant(d);
				if((i+j)%2==1)
					adj[j][i] = adj[j][i].multiply(new BigDecimal(-1));
			}

		
		BigDecimal det = new BigDecimal(1).divide(determinant(a),10000, RoundingMode.HALF_UP);
		
		adj = multiply(adj,b);
		
		adj = multiplyScalar(adj,det);
		
		for(int i=0;i<adj.length;i++)
		{
			for(int j=0;j<adj[0].length;j++)
				System.out.print(adj[i][j].doubleValue());
			System.out.println();
		}
		
	}
	
}
