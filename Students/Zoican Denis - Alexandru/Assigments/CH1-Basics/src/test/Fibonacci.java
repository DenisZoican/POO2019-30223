package test;

public class Fibonacci {

	public void Fibonacci_n() {
		int a1 = 0;
		int a2 = 1;
		int cur = 0;
		
		long suma = 0;
		
		while(cur <= 4000000)
		{
			cur = a1+a2;
			if(cur%2==0)
				suma+=cur;
			
			a1 = a2;
			a2 = cur;	
		}
		
		System.out.println(suma);
	}
	
	public int[][] multiply(int m1[][],int m2[][])
	{		  
		int[][] F = new int[2][2];
		F[0][0] = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];; 
		F[0][1] = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];  
		F[1][0] = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];  
		F[1][1] = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1]; 
		
		return F;
	}
	
	public int[][] pow(int m[][],int n)
	{
		if(n==1)
			return m;
		if(n==0)
			return null;
		
		int[][] m2 = pow(m,n/2);
		
		int[][] m3 = {{1,1},{1,0}};
	
		m2 = multiply(m2,m2);
		if(n%2 == 1)
			m2 = multiply(m2,m3);
		
		return m2;
	}
	
	public void Fibonacci_log(int n) {
		int m[][]= {{1,1},{1,0}};
		pow(m,n-1); ///Calculam elementul de pe pozitia n in sirul lui Fibonacci in logn folosind puterile matricei
		System.out.println(m[0][0]);
	}
	
	public static void main(String[] args) {
			
		Fibonacci fibo = new Fibonacci();
		fibo.Fibonacci_n(); ///Afisam suma in log(n)
		
		int[][] f = {{1,1},{1,0}}; ///Aflam elementul in log(n)
		int[][] m = fibo.pow(f,1000);
		System.out.println(m[0][0]);
		
	}
}
