package test;

public class LargestPalindrom {

	static boolean palin (int m) {
		String mr = String.valueOf(m);
		int len = mr.length();
		for(int i=0;i<len/2;i++)
		{
			if(mr.charAt(i) !=mr.charAt(len-i-1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int maxi = -1;
		int i1 = -1;
		int j1 = -1;
		for(int i=999;i>=100;i--)
			for(int j=999;j>=100;j--)
			{
				int m = i*j;
				if(palin(m)==true)
				{
					if(m>maxi)
						{
							maxi = m;
							i1 = i;
							j1 = j;
						}
				}
			}
		
		System.out.println("Palindromul este "+maxi+"="+i1+"*"+j1);
		
		maxi = -1;
		i1 = -1;
		j1 = -1;
		
		for(int i=9999;i>=1000;i--)
			for(int j=9999;j>=1000;j--)
			{
				int m = i*j;
				if(palin(m)==true)
				{
					if(m>maxi)
						{
							maxi = m;
							i1 = i;
							j1 = j;
						}
				}
			}
		
		System.out.println("Palindromul este "+maxi+"="+i1+"*"+j1);
	}

}
