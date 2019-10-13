package test;

import java.util.Scanner;

public class SumOfMultiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///Valoarea int este 60000041
		///Valoarea long este 9223372036854775804
		
		Scanner scanner = new Scanner(System.in);
		
		long nr = scanner.nextLong();

		nr--;
		
		long sum1 = (nr/3*(nr/3+1))/2*3;

		long sum2 = (nr/5*(nr/5+1))/2*5;
		
		long sum3 = (nr/15*(nr/15+1))/2*15;
		
		long total = sum1+sum2-sum3;
	
		System.out.println(total);
	}

}
