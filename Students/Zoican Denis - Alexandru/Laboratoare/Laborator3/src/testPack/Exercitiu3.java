package testPack;

public class Exercitiu3 {

	protected String voc = new String("aeiouAEIOU");
	public int nrConsoane (String s)
	{
		if(s.length()==0)
		{
			return 0;
		} else {
			if(voc.indexOf(s.charAt(s.length()-1))==-1 && s.charAt(s.length()-1)>='A' && s.charAt(s.length()-1)<='z')
			return 1+nrConsoane(s.substring(0,s.length()-1));
			else
			return nrConsoane(s.substring(0,s.length()-1));
		}
	}
	
	public int nrVocale (String s)
	{
		if(s.length()==0)
		{
			return 0;
		} else {
			if(voc.indexOf(s.charAt(s.length()-1))!=-1)
			{
				return 1+nrVocale(s.substring(0,s.length()-1));
			}
			else
			{
				return nrVocale(s.substring(0,s.length()-1));
			}
		}
	}
	
	public void pozitie (String s,char c)
	{
		int k = 0;
		while(s.indexOf(c)!=-1)
		{
			int index = s.indexOf(c);
			System.out.print((k+index)+" ");
			k=k+index+1;
			s = s.substring(index+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercitiu3 eu = new Exercitiu3();
		String s = new String("aa2acdea");
		
		eu.pozitie(s,'a');
	}

}
