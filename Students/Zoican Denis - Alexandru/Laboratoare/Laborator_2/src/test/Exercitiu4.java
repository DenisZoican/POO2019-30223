package test;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercitiu4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		
		BigInteger s = BigInteger.valueOf(1);
		BigInteger doi = BigInteger.valueOf(2);
		
		for(int j=0;j<i;j++)
		{
			s.multiply(doi);
		}
	
		System.out.println(s);
	}

}
